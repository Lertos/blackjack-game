public class Bank {

    private int balance;
    public Bank(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int cash) {
        this.balance += cash;
    }

    public boolean withdraw(int cash) {
        if (cash >= balance) {
            this.balance -= cash;
            return true;
        }
        return false;
    }

}
