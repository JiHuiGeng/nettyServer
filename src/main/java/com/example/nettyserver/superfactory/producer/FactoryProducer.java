package com.example.nettyserver.superfactory.producer;

import com.example.nettyserver.superfactory.abstactfactory.AbstractFactory;
import com.example.nettyserver.superfactory.factory.ColorFactory;
import com.example.nettyserver.superfactory.factory.ShapeFactory;

public class FactoryProducer {
  public static AbstractFactory getFactory(String choice) {
    if (choice.equalsIgnoreCase("SHAPE")) {
      return new ShapeFactory();
    } else if (choice.equalsIgnoreCase("COLOR")) {
      return new ColorFactory();
    }
    return null;
  }
}
