package com.example.nettyserver;

import com.example.nettyserver.service.RedisTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class NettyServerApplicationTests {

  @Autowired
  private RedisTemplateService redisTemplateService;

  @Before
  public void setUp(){

  }

  @Test
  public void contextLoads() {
    String valueByKey = redisTemplateService.getValueByKey("demo");
    log.debug("这是一个单元测试"+valueByKey);
  }

}
