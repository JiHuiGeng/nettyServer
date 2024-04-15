package com.example.nettyserver.superfactory.factory;

import com.example.nettyserver.superfactory.abstactfactory.AbstractFactory;
import com.example.nettyserver.superfactory.service.Color;
import com.example.nettyserver.superfactory.service.Shape;
import com.example.nettyserver.superfactory.service.impl.Blue;
import com.example.nettyserver.superfactory.service.impl.Green;
import com.example.nettyserver.superfactory.service.impl.Red;
import org.springframework.util.StringUtils;

public class ColorFactory extends AbstractFactory {
  @Override
  public Color getColor(String color) {
    if (StringUtils.isEmpty(color)) {
      return null;
    }

    if (color.equalsIgnoreCase("RED")) {
      return new Red();
    } else if (color.equalsIgnoreCase("GREEN")) {
      return new Green();
    } else if (color.equalsIgnoreCase("BLUE")) {
      return new Blue();
    }
    return null;
  }

  @Override
  public Shape getShape(String shape) {
    return null;
  }
}
