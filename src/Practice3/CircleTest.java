package Practice3;

public class CircleTest {
    public static void main(String[] args) {
    Circle circ1 = new Circle();
    circ1.setXpos(3);
    circ1.setYpos(-2);
    circ1.setRadius(5);
    System.out.println("X position: " + circ1.getXpos());
    System.out.println("Y position: " + circ1.getYpos());
    System.out.println("radius: " + circ1.getRadius());
    }
}
class Circle{
    private double xpos=0;
    private double ypos=0;
    private double radius=0;

    public double getRadius() {
        return radius;
    }

    public double getXpos() {
        return xpos;
    }

    public double getYpos() {
        return ypos;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setXpos(double xpos) {
        this.xpos = xpos;
    }

    public void setYpos(double ypos) {
        this.ypos = ypos;
    }
}
