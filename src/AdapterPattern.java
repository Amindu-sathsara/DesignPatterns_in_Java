//Create a Shape interface
interface Shape {
    void draw();
}

//Create a concrete class implementing the Shape interface for circles
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

//Create a Rectangle class that does not implement Shape interface
class Rectangle {
    public void drawRectangle() {
        System.out.println("Drawing a Rectangle");
    }
}

//Create an Adapter class implementing the Shape interface to adapt Rectangle
class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    @Override
    public void draw() {
        rectangle.drawRectangle();
    }
}

//Use the Shape interface to draw different shapes
public class AdapterPattern {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        Rectangle rectangle = new Rectangle();
        Shape rectangleAdapter = new RectangleAdapter(rectangle);
        rectangleAdapter.draw();
    }
}
