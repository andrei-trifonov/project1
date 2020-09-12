public class Practice2 {
    public static void main(String[] args) {



        Dog one = new Dog("Default", 0);
        pitomnikSobak pitomnik = new pitomnikSobak();
        one.Accessor3("Bob");
        one.Accessor4(13);
        pitomnik.addDog(1,one);
        pitomnik.Test(one);
        System.out.println("human age " + one.humanAge());
    }


}

class pitomnikSobak {
    Dog[] sobaki = new Dog[5];
    public void addDog(int i, Dog dog){
        sobaki[i] = dog;
    }
    public void Test(Dog dog){
        System.out.println(dog.toString());
    }
}
class Dog{
    private String Dog_name;
    private int Dog_age;

    public Dog(String name, int age)
    {
      Dog_name = name;
      Dog_age = age;
    }

    public String Accessor1(){
        return Dog_name;
    }
    public int Accessor2(){
        return Dog_age;
    }
    public void Accessor3(String name){
        Dog_name = name;
    }
    public void Accessor4(int age){
        Dog_age = age;
    }
    public int humanAge(){
        return Dog_age*7;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Dog_name='" + Dog_name + '\'' +
                ", Dog_age=" + Dog_age +
                '}';
    }
}