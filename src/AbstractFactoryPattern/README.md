---
title: 设计模式之抽象工厂模式
date: 2017-12-23 14:10:21
categories:
- 开发
- 设计模式
tags:
- 设计模式
- java
- 抽象工厂模式
---
## 概念
　　抽象工厂模式属于创建型涉及模式，在我理解看来抽象工厂模式和就是工厂模式，之不过此时的产品变成了工厂而已。在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
<!--more-->
## 实现

 1. 形状接口类 
    
    Shape
    ```java
    public interface Shape {
       void draw();
    }
    ```

 2. 实现形状接口的类  
 
    Rectangle
    ```java
    public class Rectangle implements Shape {
    
       public void draw() {
          System.out.println("绘制矩形。");
       }
    }
    ```
    Square
    ```java
   public class Square implements Shape {
    
       public void draw() {
          System.out.println("绘制正方形。");
       }
    }
    ```

 3. 颜色接口类
    Color
    ```java
    public interface Color {
       void fill();
    }
    ```

 4. 实现颜色接口的类
    Red
    ```java
    public class Red implements Color {
    
       public void fill() {
          System.out.println("填充红色。");
       }
    }
    ```
    Blue
    ```java
    public class Blue implements Color {
    
       public void fill() {
          System.out.println("填充蓝色。");
       }
    }
    ```

 5. 建立工厂类的工厂类  
    
    AbstractFactory
    ```java
    public abstract class AbstractFactory {
       abstract Color getColor(Class<?> color);
       abstract Shape getShape(Class<?> shape) ;
    }
    ```

 6. 创建扩展了 AbstractFactory 的工厂类
    ShapeFactory
    ```java
    public class ShapeFactory extends AbstractFactory {
        
        @Override
        public Shape getShape(Class<?> shape){
            try {
                return (Shape)Class.forName(shape.getName()).newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
       
       @Override
       Color getColor(Class<?> color) {
          return null;
       }
    }
    ```
    ColorFactory
    ```java
    public class ColorFactory extends AbstractFactory {
        
        @Override
        public Shape getShape(Class<?> shape){
            return null;
        }
       
       @Override
       Color getColor(Class<?> color) {
            try {
                return (Color)Class.forName(color.getName()).newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
          return null;
       }
    }
    ```
    
 7. 创建一个工厂创造器/生成器类
    FactoryProducer
    ```java
    public class FactoryProducer {
        public static AbstractFactory getFactory(Class<? extends AbstractFactory> factory){
            try {
                return (AbstractFactory)Class.forName(factory.getName()).newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
          return null;
       }
    }
    ```

 8. 测试
    Main
    ```java
    public class Main {
        public static void main(String[] args) {
    
            //获取形状工厂
            AbstractFactory shapeFactory = FactoryProducer.getFactory(ShapeFactory.class);
    
            //获取形状为 Rectangle 的对象
            Shape shape1 = shapeFactory.getShape(Rectangle.class);
    
            //调用 Rectangle 的 draw 方法
            shape1.draw();
    
            //获取形状为 Square 的对象
            Shape shape2 = shapeFactory.getShape(Square.class);
    
            //调用 Square 的 draw 方法
            shape2.draw();
    
            //获取颜色工厂
            AbstractFactory colorFactory = FactoryProducer.getFactory(ColorFactory.class);
    
            //获取颜色为 Red 的对象
            Color color1 = colorFactory.getColor(Red.class);
    
            //调用 Red 的 fill 方法
            color1.fill();
    
            //获取颜色为 Blue 的对象
            Color color2 = colorFactory.getColor(Blue.class);
    
            //调用 Blue 的 fill 方法
            color2.fill();
       }
    }
    ```

## 输出结果  
    绘制矩形。
    绘制正方形。
    填充红色。
    填充蓝色。
## 注意事项
　　产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。