package AbstractFactoryPattern;

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