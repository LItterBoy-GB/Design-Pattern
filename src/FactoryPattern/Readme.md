---
title: 设计模式之工厂模式
date: 2017-12-21 15:15:21
categories:
- 开发
- 设计模式
tags:
- 设计模式
- java
- 工厂模式
---
## 概念
　　工厂模式属于创建型涉及模式，它提供了一种创建对象的最佳方式。在创建的过程中使用者不需要知道创建的逻辑过程，就像一家造纸厂制造纸张一样，客户只需要关系我要什么纸张，纸张的制造流程并不关心。
<!--more-->
## 实现

 1. 抽象产品类 
    
    People
    ```java
    public interface People {
        void say();
    }
    ```

 2. 实现具体的产品类  
 
    Student
    ```java
    public class Student implements People {
        public void say(){
            System.out.println("我是一名学生。");
        }
    }
    ```
    Teacher
    ```java
    public class Teacher implements People {
        public void say(){
            System.out.println("我是一名教师。");
        }
    }
    ```

 3. 建立工厂类  
    
    FactoryPeople
    ```java
    public class FactoryPeople {
        public static People buidlerPeople(Class<?extends People> clazz){
            try {
              return (People)Class.forName(clazz.getName()).newInstance();
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

 4. 使用工厂构造所需产品
    Main
    ```java
    public class Main {
        public static void main(String args[]){
            //制造一名学生
            People student = FactoryPeople.buidlerPeople(Student.class);
            student.say();
            //制造一名教师
            People teacher = FactoryPeople.buidlerPeople(Teacher.class);
            teacher.say();
        }
    }
    ```
    
## 输出结果  
    我是一名学生。
    我是一名教师。
## 注意事项
　　作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。
  
[项目代码](https://github.com/LItterBoy-GB/Design-Pattern)