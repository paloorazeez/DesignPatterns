package dp.structural.bridge;

public class BridgePatternDemo {

    public static void main(String[] args) {

        Shape shape = new Circle(new Blue());
        shape.draw();
    }
}

abstract class Shape{

    private  Colour colour; // bridge interface

    public Shape(Colour colour) {
        this.colour = colour;
    }

    abstract void draw();

    public Colour getColour() {
        return colour;
    }
}

interface Colour{

    void fill();
}

class Square extends Shape{


    public Square(Colour colour) {
        super(colour);
    }

    @Override
    void draw() {

    }
}

class Circle extends Shape
{
    public Circle(Colour colour) {
        super(colour);
    }

    @Override
    void draw() {
        System.out.println("Drawing circle");
        System.out.println("with colour: ");
        getColour().fill();
    }

}

class Red implements Colour{

    @Override
    public void fill() {
        System.out.println("Filling RED colour");
    }
}

class Blue implements Colour{


    @Override
    public void fill() {
        System.out.println("Filling BLUE colour");
    }
}

