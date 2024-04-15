package com.example.nettyserver.superfactory.service.impl;

import com.example.nettyserver.superfactory.service.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Red implements Color {
  @Override
  public void fill() {
    log.debug("Red fill");
  }
}
