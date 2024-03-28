package com.example.nettyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NettyServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NettyServerApplication.class, args);
  }

}
