
public class Practice2_1 {
    public static void main(String[] args) {
        Shape1 one = new Shape1();
        GetShape two = new GetShape(one);


    }
}
class Shape1 {
    String shape1 = "Круг";


}
class GetShape extends Shape1 {
    public GetShape(Shape1 obj) {
        System.out.println(obj.shape1);
    }
}
