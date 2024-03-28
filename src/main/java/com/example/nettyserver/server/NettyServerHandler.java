package com.example.nettyserver.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    //获取客户端发送的消息
    ByteBuf byteBuf = (ByteBuf) msg;
    String s = byteBuf.toString(StandardCharsets.UTF_8);
    log.debug("NettyServerHandler.channelRead->received a msg from client server:{}", byteBuf.toString(StandardCharsets.UTF_8));
    if (!StringUtil.isNullOrEmpty(s)) {
      ctx.writeAndFlush(Unpooled.copiedBuffer("你好，客户端-这里是服务端，我已收到你的消息", StandardCharsets.UTF_8)).addListener(future -> {
        if (future.isSuccess() && future.isDone()) {
          log.debug("消息已发送成功，客户端已接收");
        }
      });
    }
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    log.debug("NettyServerHandler.channelReadComplete");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    log.error("NettyServerHandler.exceptionCaught");
    ctx.close();
  }

}
