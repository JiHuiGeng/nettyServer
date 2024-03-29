package com.example.nettyserver.service.impl;

import com.example.nettyserver.service.RedisTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RedisTemplateServiceImpl implements RedisTemplateService {
  private final RedisTemplate<String, String> redisTemplate;

  /**
   * 通过key获取value
   *
   * @param key key
   * @return
   */
  @Override
  public String getValueByKey(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  /**
   * 插入key ,value
   *
   * @param key   key
   * @param value value
   */
  @Override
  public void setKeyValue(String key, String value) {
    redisTemplate.opsForValue().set(key, value);
  }

  /**
   * 查询key的过期时间
   *
   * @param key key
   * @return
   */
  @Override
  public Long getKeyExpiredTime(String key) {
    return redisTemplate.getExpire(key);
  }

  /**
   * redis 输出命令执行结果
   *
   * @param cmd 命令
   */
  @Override
  public void outPutLog(String cmd,String url) {

  }

}
