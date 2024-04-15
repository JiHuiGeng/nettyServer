package com.example.nettyserver.superfactory.abstactfactory;

import com.example.nettyserver.superfactory.service.Color;
import com.example.nettyserver.superfactory.service.Shape;

public abstract class AbstractFactory {

  public abstract Color getColor(String color);

  public abstract Shape getShape(String shape);
}
