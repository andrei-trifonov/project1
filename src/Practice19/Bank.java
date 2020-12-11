package Practice19;
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
        System.out.println("Число банковских счетов: ");
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
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }



    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (!accounts.get(fromAccountNum).getBlocked() && !accounts.get(toAccountNum).getBlocked()){
            if (amount > 50000){
                if (isFraud(fromAccountNum,toAccountNum,amount)){
                    accounts.get(fromAccountNum).setBlocked(true);
                    accounts.get(toAccountNum).setBlocked(true);
                    System.out.println("Счета заблокированы: " + fromAccountNum + " , " + toAccountNum);
                }
                else{
                    if (accounts.get(fromAccountNum).getMoney()>=amount) {
                            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney()-amount);
                            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney()+amount);

                    }
                    else {
                            System.out.println("Недостаточно средств для перевода, счет:" + fromAccountNum);
                    }
                }
            }
            else {
                if (accounts.get(fromAccountNum).getMoney()>=amount)
                {
                    accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney()-amount);
                    accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney()+amount);
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


    public long getBalance(String accountNum)
    {
       return accounts.get(accountNum).getMoney();
    }
}
class Starter
{
    public static void main(String[] args) throws InterruptedException {
        Bank omegaBank = new Bank();
        omegaBank.StartUp();
        while (true) {
            System.out.println("Узнать баланс - 1, перевести средства - 2");
            try {
                Scanner in = new Scanner(System.in);
                int choose = in.nextInt();
                if (choose == 2) {
                    System.out.println("Сколько одновременных переводов?");
                    Scanner in1 = new Scanner(System.in);

                    long amount = in1.nextLong();
                    for (long i = 0; i < amount; i++) {
                        Scanner in2 = new Scanner(System.in);
                        System.out.println("Перевод № " + (i + 1));
                        System.out.println("Введите номер счета отправителя");
                        String sender = in2.nextLine();
                        System.out.println("Введите номер счета получателя");
                        String receiver = in2.nextLine();
                        System.out.println("Введите сумму");
                        long money = in2.nextLong();
                        omegaBank.transfer(sender, receiver, money);
                    }
                }

            if (choose == 1) {
                System.out.println("Сколько одновременных запросов?");
                Scanner in1 = new Scanner(System.in);
                long numb = in1.nextLong();
                for (long i = 0; i < numb; i++) {
                    System.out.println("Введите номер счета");
                    Scanner in2 = new Scanner(System.in);
                    String num = in2.nextLine();
                    long amount = omegaBank.getBalance(num);
                    System.out.println("Счет номер: " + num + " текущий баланс: " + amount);

                }
            }
        }
        catch (Exception e){
            System.out.println("Ошибка при обработке запроса");
        }
        }

    }
}