package com.example.nettyserver.superfactory.factory;

import com.example.nettyserver.superfactory.abstactfactory.AbstractFactory;
import com.example.nettyserver.superfactory.service.Color;
import com.example.nettyserver.superfactory.service.Shape;
import com.example.nettyserver.superfactory.service.impl.Circle;
import com.example.nettyserver.superfactory.service.impl.Rectangle;
import com.example.nettyserver.superfactory.service.impl.Square;
import org.springframework.util.StringUtils;

public class ShapeFactory extends AbstractFactory {
  @Override
  public Color getColor(String color) {
    return null;
  }

  @Override
  public Shape getShape(String shape) {

    if (StringUtils.isEmpty(shape)) {
      return null;
    }

    if (shape.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    } else if (shape.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();
    } else if (shape.equalsIgnoreCase("SQUARE")) {
      return new Square();
    }
    return null;
  }
}
