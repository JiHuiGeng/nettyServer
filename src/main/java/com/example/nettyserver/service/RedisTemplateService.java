package com.example.nettyserver.service;


public interface RedisTemplateService {


  String getValueByKey(String key);

  void setKeyValue(String key, String value);

  Long getKeyExpiredTime(String key);

  void outPutLog(String cmd,String url);
}
