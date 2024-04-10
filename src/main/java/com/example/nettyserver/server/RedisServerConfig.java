package com.example.nettyserver.server;

import com.example.nettyserver.config.RedisConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * redis配置
 *
 * @author gengjihui
 */
@Configuration
@AllArgsConstructor
public class RedisServerConfig {
  private final RedisConfig redisConfigEntity;

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {

    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setPort(redisConfigEntity.getPort());
    redisStandaloneConfiguration.setHostName(redisConfigEntity.getHost());
    return new LettuceConnectionFactory(redisStandaloneConfiguration);
  }
}
