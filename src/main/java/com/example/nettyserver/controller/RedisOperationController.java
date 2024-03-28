package com.example.nettyserver.controller;

import com.example.nettyserver.service.RedisTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gengjihui
 */

@AllArgsConstructor
@RestController
@RequestMapping(value = "/redis")
public class RedisOperationController {

  private final RedisTemplateService redisTemplateService;

  /**
   * 根据key 查询value
   *
   * @param key 需要查询对应value的key
   * @return 查询到的value
   */
  @GetMapping("/getValueByKey")
  public String getValueByKey(@RequestParam String key) {
    String valueByKey = redisTemplateService.getValueByKey(key);
    return StringUtils.isEmpty(valueByKey) ? null : valueByKey;
  }



}
