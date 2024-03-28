package com.example.nettyserver.listener;

import com.example.nettyserver.server.NettyServer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ApplicationRunEventListener {

  private final NettyServer nettyServer;

  /**
   * springboot服务启动监听
   *
   * @throws Exception
   */
  @EventListener(value = ApplicationStartedEvent.class)
  public void runListener() throws Exception {
    //初始化netty服务
    nettyServer.initNettyServer();
  }

}
