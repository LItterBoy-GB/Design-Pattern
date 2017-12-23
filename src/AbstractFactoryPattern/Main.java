package AbstractFactoryPattern;

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