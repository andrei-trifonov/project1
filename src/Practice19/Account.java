package Practice19;

import java.util.concurrent.atomic.AtomicLong;

public class Account
{
    private  boolean blocked;
    private AtomicLong money = new AtomicLong(0);
    private String accNumber;

    public  Account(String accNumber, long money){
        this.accNumber = accNumber;
        this.money.set(money);
        blocked = false;
    }
    public long getMoney() {
        return money.get();
    }

    public String getAccNumber() {
        return accNumber;
    }
    public boolean getBlocked() {
        return blocked;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setMoney(long money) {
        this.money.set(money);
    }
}