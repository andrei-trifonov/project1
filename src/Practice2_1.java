
public class Practice2_1 {
    public static void main(String[] args) {
        Shape one = new Shape();
        GetShape two = new GetShape(one);


    }
}
class Shape {
    String shape = "Круг";


}
class GetShape extends Shape{
    public GetShape(Shape obj) {
        System.out.println(obj.shape);
    }
}
