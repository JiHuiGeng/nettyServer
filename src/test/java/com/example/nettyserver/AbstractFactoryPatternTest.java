package com.example.nettyserver;

import com.example.nettyserver.superfactory.abstactfactory.AbstractFactory;
import com.example.nettyserver.superfactory.producer.FactoryProducer;
import com.example.nettyserver.superfactory.service.Color;
import com.example.nettyserver.superfactory.service.Shape;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbstractFactoryPatternTest {

  @Test
  public void testAbstractFactory() {
    AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
    Shape circle = shapeFactory.getShape("CIRCLE");
    circle.draw();

    Shape rectangle = shapeFactory.getShape("RECTANGLE");
    rectangle.draw();

    Shape square = shapeFactory.getShape("SQUARE");
    square.draw();

    AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

    Color red = colorFactory.getColor("RED");
    red.fill();

    Color green = colorFactory.getColor("GREEN");
    green.fill();


    Color blue = colorFactory.getColor("BLUE");
    blue.fill();

  }
}
