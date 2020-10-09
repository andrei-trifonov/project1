package Practice10;
import java.util.*;


public class Employee {
    private double finalsalary;
    private String position, name, surname;
    private GregorianCalendar birthDate;
    Employee(){}

    Employee(String position){
        this.position = position;
    }

    void setFinalsalary(double finalsalary){
        this.finalsalary = finalsalary;
    }
    double getFinalsalary(){
        return finalsalary;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public GregorianCalendar getBirthDate() {
        return birthDate;
    }
    public String getSurname() {
        return surname;
    }
}

interface EmployeePosition{
    String getJobTitle();
    double calcSalary(double baseSalary);
}

class Manager implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        double temp = Math.round(115000 + (Math.random()) * ((140000 - 115000) + 1));
        return 0.05 * temp + baseSalary;
    }
}

class TopManager implements EmployeePosition{
    int Income;
    TopManager(int Income)
    {
        this.Income = Income;

    }
    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (Income > 10000000){
            return 1.5 * baseSalary + baseSalary;
        } else{
            return baseSalary;
        }
    }
}

class Operator implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
interface employersHandler{
    void handleEmployers(String post, int num, Company company, String whatToDo);
}
class Company implements employersHandler {
    public ArrayList<Employee> employees = new ArrayList<Employee>();
    public double operator_salary;
    public double manager_salary;
    public double topmanager_salary;
    void hire (String pos, Employee em){
        switch (pos) {
            case "Manager":  em.setFinalsalary(new Manager().calcSalary(manager_salary));
                em.setPosition(new Manager().getJobTitle());
                break;
            case "Top Manager":  em.setFinalsalary(new TopManager(getIncome()).calcSalary(topmanager_salary));
                em.setPosition(new TopManager(getIncome()).getJobTitle());
                break;
            case "Operator":  em.setFinalsalary(new Operator().calcSalary(operator_salary));
                em.setPosition(new Operator().getJobTitle());
                break;
        }
    }
    void hireAll(String pos, int amount) {
        for (int i = 0; i < amount; i++) {
            switch (pos) {
                case "Manager":
                    employees.add(i, new Employee(new Manager().getJobTitle()));
                    employees.get(i).setFinalsalary(new Manager().calcSalary(manager_salary));

                    break;
                case "Top Manager":
                    employees.add(i, new Employee(new TopManager(getIncome()).getJobTitle()));
                    employees.get(i).setFinalsalary(new TopManager(getIncome()).calcSalary(topmanager_salary));
                    break;
                case "Operator":
                    employees.add(i, new Employee(new Operator().getJobTitle()));
                    employees.get(i).setFinalsalary(new Operator().calcSalary(operator_salary));
                    break;
            }
        }
        System.out.println(amount + " employees hired.");
    }


    void fire(int amount){
        for(int i=0; i<amount; i++) {

            employees.remove(i);
        }
    }





    int getIncome(){
        double Income=0;
        for(int i=0; i< employees.size();i++){
            if (employees.get(i).getPosition()=="Manager"){
                Income += (employees.get(i).getFinalsalary()-manager_salary)/0.05;
            }
        }
        return (int)Income;
    }

    @Override
    public void handleEmployers(String post, int num, Company company, String whatToDo) {
        switch (whatToDo) {
            case "Hire":
            {
                company.hireAll(post, num);
            }
            break;
            case "Fire":
            {
                company.fire(num);
            }
            break;

        }
    }

    public static void main(String[] args) {

        employersHandler anonimous = new employersHandler() {
            @Override
            public void handleEmployers(String post, int num, Company company, String whatToDo) {
                switch (whatToDo) {
                    case "Hire":
                    {
                        company.hireAll(post, num);
                    }
                    break;
                    case "Fire":
                    {
                        company.fire(num);
                    }
                    break;

                }}
        };
        employersHandler lambda = (String post, int num, Company company, String whatToDo) -> {

            switch (whatToDo) {
                case "Hire":
                {
                    company.hireAll(post, num);
                }
                break;
                case "Fire":
                {
                    company.fire(num);
                }
                break;

            }

        };
        Company company1 = new Company();
        company1.manager_salary = 150000;
        company1.operator_salary = 100000;
        company1.topmanager_salary = 150000;
        company1.handleEmployers("Operator", 10, company1, "Hire" );
        lambda.handleEmployers("Manager",150,company1,"Hire");
        anonimous.handleEmployers("Top Manager",5,company1,"Hire");



    }
}