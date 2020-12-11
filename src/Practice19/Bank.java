package Practice19;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Bank extends Thread
{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public void StartUp(){
        HashMap<String, Account> start = new HashMap<String, Account>();
        long max = 100000;
        long min = 0;
        System.out.println("Число банковских счетов (номер счета будет равен порядковому номеру): ");
        Scanner in = new Scanner(System.in);
        try {

            long num = in.nextLong();
            for (long i = 0; i < num; i++) {
                max -= min;
                long money = (long) ((Math.random() * ++max) + min);
                start.put(String.valueOf(i), new Account(String.valueOf(i), money));
            }
        }
        catch (Exception e){
            System.out.println("Ошибка при создании БД");
        }
        accounts = start;
        System.out.println("Введите число операций");
        Scanner in1 = new Scanner(System.in);
        long amount = in1.nextLong();
        try {
            ArrayList <Thread> threads = new ArrayList<>();
        for (int k=0; k<amount; k++) {
            System.out.println("Узнать баланс - 1, перевести средства - 2");

                Scanner in3 = new Scanner(System.in);
                int choose = in3.nextInt();
                ArrayList <String> sender = new ArrayList<>();
                ArrayList <String> receiver = new ArrayList<>();
                ArrayList <Long> money = new ArrayList<>();
                ArrayList <String> account = new ArrayList<>();


                 if (choose == 2) {
                        Scanner in2 = new Scanner(System.in);
                        System.out.println("Введите номер счета отправителя");
                        sender.add(in2.nextLine());
                        System.out.println("Введите номер счета получателя");
                        receiver.add (in2.nextLine());
                        System.out.println("Введите сумму");
                        money.add(in2.nextLong());
                     int finalK = receiver.size()-1;
                     threads.add(new Thread(()->{
                         try {
                             this.transfer(sender.get(finalK), receiver.get(finalK), money.get(finalK));
                         }
                         catch (Exception e){
                             System.out.println("Ошибка транзакции");
                         }
                     }));
                    }


                if (choose == 1) {
                        System.out.println("Введите номер счета");
                        Scanner in2 = new Scanner(System.in);
                        account.add(in2.nextLine());
                    int finalK1 = account.size()-1;
                    threads.add(  new Thread(()-> {
                              long amount1 = this.getBalance(account.get(finalK1));
                                 System.out.println("Счет номер: " + account.get(finalK1) + " текущий баланс: " + amount1);
                    }));
                }


            }
            for (int i = 0; i < amount; i++){
                threads.get(i).start();
            }
        }
        catch (Exception e){
            System.out.println("Ошибка при обработке запроса");
        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }




    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (!accounts.get(fromAccountNum).getBlocked() && !accounts.get(toAccountNum).getBlocked()){
            if (amount > 50000){

                if (isFraud(fromAccountNum,toAccountNum,amount)){
                    accounts.get(fromAccountNum).setBlocked(true);
                    accounts.get(toAccountNum).setBlocked(true);
                    System.out.println("Счета заблокированы: " + fromAccountNum + " , " + toAccountNum);
                }
                else{
                    if (accounts.get(fromAccountNum).getMoney()>=amount) {
                        new Thread(()-> {
                                accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                        }).start();
                        new Thread(()-> {
                                accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                        }).start();
                    }
                    else {
                        System.out.println("Недостаточно средств для перевода, счет:" + fromAccountNum);
                    }
                }
            }
            else {
                if (accounts.get(fromAccountNum).getMoney()>=amount)
                {
                    new Thread(()-> {
                        synchronized (this) {
                            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                        } }).start();
                    new Thread(()-> {
                        synchronized (this) {
                            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                        } }).start();
                }
                else {
                    System.out.println("Недостаточно средств для перевода, счет:" + fromAccountNum);
                }

            }
        }
        else {
            System.out.println("Счета заблокированы: " + fromAccountNum + " , " + toAccountNum);
        }
    }


    public synchronized long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }
}
class Starter
{
    public static void main(String[] args) throws InterruptedException {
        Bank omegaBank = new Bank();
        omegaBank.StartUp();

        }

    }