package AbstractFactoryPattern;

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