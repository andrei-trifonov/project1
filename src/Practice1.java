import java.util.Random;
public class Practice1 {
    public static void Show(int [] array1){
        for (int i=0;i<10;i++){
            System.out.println(array1[i]+' ');
        }
    }
    public static void Sort(int [] array1){
        int tmp;
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if (array1[j]<array1[i]){
                    tmp = array1[j];
                    array1[j]=array1[i];
                    array1[i]=tmp;
                }
            }
        }
    }
    public static void Random1(int [] array1){
        int rnd;

        for (int i=0;i<10;i++){
            rnd = (int) Math.abs(Math.random()*200 - 100)%100;
            array1[i]=rnd;
        }
        System.out.println("Случайный массив1");
        Show(array1);
        System.out.println("Сортировка");
        Sort(array1);
        Show(array1);
    }
    public static void Random2(int [] array1){
        int rnd;
        Random random = new Random();
        for (int i=0;i<10;i++){
            rnd = random.nextInt(100 + 1);;
            array1[i]=rnd;
        }
        System.out.println("Случайный массив2");
        Show(array1);
    }
    public static void forCycle(int [] array1){
        int sum = 0;
        for (int i=0;i<10;i++){
            sum += array1[i];
        }
        System.out.println("Сумма for " + sum);
    }
    public static void whileCycle(int [] array1){
        int sum = 0;
        int i = 0;
        while (i<10){
            sum += array1[i];
            i++;
        }
        System.out.println("Сумма while " + sum);
    }
    public static void doWhileCycle(int [] array1){
        int sum = 0;
        int i = 0;
       do{
            sum += array1[i];
            i++;
        }
       while (i<10);
       System.out.println("Сумма dowhile " + sum);
    }
    public static void Factorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++)
            result = result*i;
        System.out.println("Факториал");
        System.out.println(result);
    }
    public static void main(String[] args) {
        int [] array1 = {1,2,3,4,5,6,7,8,9,10};
        Random1(array1);
        Random2(array1);
        forCycle(array1);
        whileCycle(array1);
        doWhileCycle(array1);
        Factorial(4);
    }
}
