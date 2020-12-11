package Practice19;
public class Account
{
    private  boolean blocked;
    private long money;
    private String accNumber;

    public  Account(String accNumber, long money){
        this.accNumber = accNumber;
        this.money = money;
        blocked = false;
    }
    public long getMoney() {
        return money;
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
        this.money = money;
    }
}
