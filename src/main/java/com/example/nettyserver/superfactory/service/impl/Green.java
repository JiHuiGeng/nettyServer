package com.example.nettyserver.superfactory.service.impl;

import com.example.nettyserver.superfactory.service.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Green implements Color {
  @Override
  public void fill() {
    log.debug("Green fill");
  }
}
