
public class Practice2_1 {
    public static void main(String[] args) {
        Shape one = new Shape();
        GetShape two = new GetShape();
        System.out.println(two.getShape(one));

    }
}
class Shape {
    String shape = "Круг";


}
class GetShape extends Shape{
    public String getShape(Shape obj) {
        return obj.shape;
    }
}
