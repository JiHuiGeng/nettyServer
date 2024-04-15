package com.example.nettyserver.superfactory.service.impl;

import com.example.nettyserver.superfactory.service.Shape;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle implements Shape {
  @Override
  public void draw() {
    log.debug("Circle draw");
  }
}
