package FactoryPattern;

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
