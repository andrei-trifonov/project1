package Practice7_8;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Employee {


    String name, surname, post;
    double baseSalary;


    }

interface EmployeePosition {
  String getJobTitle();
  double calcSalary(double baseSalary);

}
class Manager implements EmployeePosition{
    int Random;
    Manager(){
    Random random = new Random();
    Random = random.nextInt(25000 + 115000);
    }
    public double calcSalary(double baseSalary){

        return baseSalary+0.05*Random;
    }


    public String getJobTitle() {
        return "Manager";
    }
}
class TopManager implements EmployeePosition{
    int Income;
    TopManager (int income){
        Income = income;
    }
    public double calcSalary(double baseSalary){
        if (Income>10000000){
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
        return  baseSalary;
    }
    public String getJobTitle() {
        return "Operator";
    }
}
class Company  {

    private int Income;
    private ArrayList<EmployeePosition> list = new ArrayList<>();

    void hire(int sort, int num){
        switch (sort){
            case 1:
                for (int i=0;i<num;i++) {
                    list.add(new Manager());

                }
                break;
            case 2:
                for (int i=0;i<num;i++) {
                    getIncome(150000);
                    list.add(new TopManager(Income));
                }break;
            case 3:
                for (int i=0;i<num;i++) {
                    list.add(new Operator());
                }break;
        }

    }

    void hireAll(int num){
        for (int i=0;i<num;i++) {
            list.add(new Manager());
            getIncome(150000);
            list.add(new TopManager(Income));
            list.add(new Operator());
        }

    }

   void  fire(int num){
        for (int i=0; i<num;i++)
        list.remove(i);

    }

    void getIncome(double baseSalary){
        Income = 0;
        for (int i=0;i< list.size();i++){
          Income+=(( list.get(i).calcSalary(baseSalary)-baseSalary)/0.05);
        }

    }

    void getTopSalaryStaff(int count){
        double salary1=0, salary2=0;

        for(int i=0;i< list.size();i++){
            switch (list.get(i).getJobTitle()){
                case "Operator": salary1 = 50000; break;
                case "TopManager": salary1 = 150000; break;
                case "Manager": salary1 =150000; break;}
            for(int j=0;j< list.size();j++){
                switch (list.get(j).getJobTitle()){
                    case "Operator": salary2 = 50000; break;
                    case "TopManager": salary2 = 150000; break;
                    case "Manager": salary2 =150000; break;}
               if ( list.get(i).calcSalary(salary1) > list.get(j).calcSalary(salary2)){
                   Collections.swap(list,i,j);
               }
                }
        }

        for (int i=0;i<count;i++){
            salary1=0;
            switch (list.get(i).getJobTitle()){
                case "Operator": salary1 = 50000; break;
                case "TopManager": salary1 = 150000; break;
                case "Manager": salary1 =150000; break;}
            System.out.println(list.get(i).calcSalary(salary1));

        }
    }

    void getLowerSalaryStaff(int count){
        double salary1=0, salary2=0;

        for(int i=0;i< list.size();i++){
            switch (list.get(i).getJobTitle()){
                case "Operator": salary1 = 50000.0; break;
                case "TopManager": salary1 = 150000.0; break;
                case "Manager": salary1 =150000.0; break;
                }
            for(int j=0;j< list.size();j++){
                switch (list.get(j).getJobTitle()){
                    case "Operator": salary2 = 50000.0; break;
                    case "TopManager": salary2 = 150000.0; break;
                    case "Manager": salary2 =150000.0; break;}
                if (( list.get(i).calcSalary(salary1)) < (list.get(j).calcSalary(salary2))){

                    Collections.swap(list,i,j);
                }
            }
        }
        for (int i=0;i<count;i++){
            switch (list.get(i).getJobTitle()){
                case "Operator": salary1 = 50000; break;
                case "TopManager": salary1 = 150000; break;
                case "Manager": salary1 = 150000; break;}
            System.out.println(list.get(i).calcSalary(salary1));

        }
    }
    public static void main(String[] args) {

        Company company1 = new Company();
        company1.hire(3,180);
        company1.hire(1,80);
        company1.hire(2,10);
        System.out.println("Топ высоких зарплат");
        company1.getTopSalaryStaff(10);
        System.out.println("Топ низких зарплат");
        company1.getLowerSalaryStaff(30);
        company1.fire(135);


    }}