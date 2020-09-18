package Practice3;

public class Human {
    public static void main(String[] args) {

        Leg leftLeg = new Leg(true, false);
        Leg rightLeg = new Leg(false, true);
        Arm leftArm = new Arm(true, false);
        Arm rightArm = new Arm(false, true);
        Head head = new Head (5);
        Body body = new Body (0);
        System.out.println(leftLeg.toString());
        System.out.println( rightLeg.toString() );
        System.out.println( leftArm.toString());
        System.out.println( rightArm.toString());
        System.out.println(head.toString() );
        System.out.println(body.toString());


    }


}
class Leg extends Human{
    private boolean isLeft;
    private boolean isRight;
    public Leg(boolean left, boolean right){
        isLeft=left;
        isRight=right;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "isLeft=" + isLeft +
                ", isRight=" + isRight +
                '}';
    }
}
class Arm extends Human{
    private boolean isLeft;
    private boolean isRight;
    public Arm(boolean left, boolean right){
        isLeft=left;
        isRight=right;
    }

    @Override
    public String toString() {
        return "Arm{" +
                "isLeft=" + isLeft +
                ", isRight=" + isRight +
                '}';
    }
}
class Head extends Human{
    private int Scale;
    public Head(int scale){
        Scale = scale;
    }

    @Override
    public String toString() {
        return "Head{" +
                "Scale=" + Scale +
                '}';
    }
}
class Body extends Human{
    private int fatIndex;
    public Body(int fatindex){
        fatIndex = fatindex;
    }

    @Override
    public String toString() {
        return "Body{" +
                "fatIndex=" + fatIndex +
                '}';
    }
}
