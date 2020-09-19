package Practice6;

public abstract class Shape {
    Shape(String name, double area) {
        this.area = area;
        this.name = name;
    }

    public String name;
    public double area;

    abstract double calculatearea();
}
class Circle extends Shape{

    private int radius;
    Circle(String name, double area, int radius){
        super (name, area);
        this.radius = radius;
    }

    @Override
    double calculatearea() {

        return 3.14 * radius * 2;

    }
}

class RectangleAndSquare extends Shape{
    protected double width;
    protected double length;
    RectangleAndSquare(String name, double area, double length, double width){
        super (name, area);
        this.width = width;
        this.length = length;
    }

    @Override
    double calculatearea() {
        return width*length;
    }
}

class Rectangle extends RectangleAndSquare{
    Rectangle (String name, double area, double width, double length)
    {

        super (name, area, width, length);
        this.width = width;
        this.length = length;

    }


    @Override
    double calculatearea() {
        return length*width;
    }
}

interface Moving{

    public void Move(double speed);
    public void MovePoint(double speed, double speed2);
}

class MovingRectangle implements Moving{

    public void Move(double speed){
        System.out.println( "current speed: " + speed);
    }
    public void MovePoint(double speed, double speed2){
        return;
    }

}

class MovablePoints implements Moving {

    public void Move(double speed){
        return;
    }
    public void MovePoint(double speed, double speed2){
        if (speed == speed2){
            System.out.println( "point1 speed equals point2 speed :  " + speed);
        }
    }

}




class Square extends RectangleAndSquare{
    Square (String name, double area, double width, double length)
    {

        super (name, area, width, length);
        this.width = width;


    }


    @Override
    double calculatearea() {
        return width*width;
    }
}
class Go {
    public static void main(String[] args) {
        Circle circ1 = new Circle("круг", 0, 5);
        System.out.println( circ1.calculatearea());
        Square square1 = new Square("квадрат", 0, 2,2);
        System.out.println( square1.calculatearea());
        Rectangle rectangle1 = new Rectangle("Прямоугольник", 0, 3, 2);
        System.out.println( rectangle1.calculatearea());
        MovingRectangle movrec1 = new MovingRectangle();
        movrec1.Move(20);
        MovablePoints movpnt1 = new MovablePoints();
        movpnt1.MovePoint(20,20);
    }
}
