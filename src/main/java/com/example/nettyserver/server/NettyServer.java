package com.example.nettyserver.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author gengjihui
 */
@Slf4j
@Component
public class NettyServer {
  public void initNettyServer() throws Exception {
    //创建两个线程组 boosGroup、workerGroup
    EventLoopGroup serverGroup = new NioEventLoopGroup();
    EventLoopGroup childGroup = new NioEventLoopGroup();
    try {
      //创建服务端的启动对象，设置参数
      ServerBootstrap bootstrap = new ServerBootstrap();
      //设置两个线程组serverGroup和childGroup
      bootstrap.group(serverGroup, childGroup)
        //设置服务端通道实现类型
        .channel(NioServerSocketChannel.class)
        //设置线程队列得到连接个数
        .option(ChannelOption.SO_BACKLOG, 128)
        //设置保持活动连接状态
        .childOption(ChannelOption.SO_KEEPALIVE, true)
        //使用匿名内部类的形式初始化通道对象
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel socketChannel) {
            //给pipeline管道设置处理器
            socketChannel.pipeline().addLast(new NettyServerHandler());
          }
        });//给childGroup的EventLoop对应的管道设置处理器

      //绑定端口号，启动服务端
      ChannelFuture channelFuture = bootstrap.bind(6666).sync();
      log.debug("NettyServer.createNettyServer->netty server is ready");
      //对关闭通道进行监听
      channelFuture.channel().closeFuture().sync();
    } finally {
      serverGroup.shutdownGracefully();
      childGroup.shutdownGracefully();
    }
  }
}
