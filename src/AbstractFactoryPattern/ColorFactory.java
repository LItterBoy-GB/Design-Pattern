package AbstractFactoryPattern;

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
