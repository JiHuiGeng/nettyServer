package com.example.nettyserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置服务启动扫描bean,并扫描yml属性文件内prefix是spring.redis下的属性内容
 *
 * @author gengjihui
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
  private String host;
  private int port;
}
