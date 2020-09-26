package Practice7_8;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Employee {


    String name, surname, post;
    int pay = Random2();
    int Random1(){
        int rnd=0;
        boolean use=false;
        if (use==false){

        Random random = new Random();
        rnd = random.nextInt(10000000 + 5000000);
        use = true;
        return rnd;}
        else
            return rnd;

    }


    }

interface EmployeePosition {
  String getJobTitle();
  double calcSalary(double baseSalary);

}
class Manager implements EmployeePosition{
    public double calcSalary(double baseSalary){
        int Random2;
        Random random = new Random();
       Random2 = random.nextInt(25000 + 115000);
        return baseSalary+0.05*Random2;
    }


    public String getJobTitle() {
        return "Manager";
    }
}
class TopManager implements EmployeePosition{
    public double calcSalary(double baseSalary){
        if (Random1()>10000000){
            return baseSalary +baseSalary*1.5;
        }
        else
            return baseSalary;
    }


    public String getJobTitle() {
        return "TopManager";
    }
}
class Operator implements EmployeePosition{
   public double calcSalary(double baseSalary){
       Random random = new Random();
       baseSalary = random.nextInt(25000 + 115000);
        return  baseSalary;
    }


    public String getJobTitle() {
        return "Operator";
    }
}
class Company extends Employee{

    public static ArrayList<Employee> hire(int sort, int num, ArrayList<Employee> list){
        switch (sort){
            case 1:
                for (int i=0;i<num;i++) {
                    list.add(new Manager());
                }
                break;
            case 2:
                for (int i=0;i<num;i++) {
                    list.add(new TopManager());
                }
            case 3:
                for (int i=0;i<num;i++) {
                    list.add(new Operator());
                }
        }
        return list;
    }

    public static ArrayList<Employee> hireAll(int num, ArrayList<Employee> list){
        for (int i=0;i<num;i++) {
            list.add(new Manager());
            list.add(new TopManager());
            list.add(new Operator());
        }
        return list;
    }

    public static ArrayList<Employee> fire(int num, ArrayList<Employee> list){
        for (int i=0; i<num;i++)
        list.remove(i);
        return  list;
    }

    int getIncome(){
    return Random1();
    }

    public static ArrayList<Employee> getTopSalaryStaff(int count, ArrayList<Employee> list){
        for(int i=0;i<=count;i++){
            for(int j=0;j<=count;j++){
               if ( list.get(i).calcSalary() < list.get(j).calcSalary()){
                   Collections.swap(list,i,j);
               }

            }
        }
        return list;

    }
    public static ArrayList<Employee> getLowestSalaryStaff(int count, ArrayList<Employee> list){
        for(int i=0;i<count;i++){
             for(int j=0;j<count;j++){
            if ( list.get(i).calcSalary() > list.get(j).calcSalary()){
                Collections.swap(list,i,j);
            }

        }
    }
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();

        list=hire(3,180,list);
        list=hire(2,10,list);
        list=hire(1,80,list);
        System.out.println("Топ высоких зарплат");
        list=getLowestSalaryStaff(30,list);
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i).calcSalary());
        }
        list=getTopSalaryStaff(30,list);
        System.out.println("Топ низких зарплат");
        for (int i = 0; i < 30; i++) {
            System.out.println(list.get(i).calcSalary());
        }
        list=fire(135,list);


    }}