import java.util.concurrent.TimeUnit;

public class BankAccount {
    int balance;

    BankAccount(int initialBalance) {
        balance = initialBalance;
    }

    public boolean takeMoney(int value, String name) throws InterruptedException {
        synchronized (this) {
            if (value <= balance) {
                TimeUnit.MILLISECONDS.sleep(100);
                balance -= value;
                System.out.println(balance + " coins is/are in the account. " + value + " coins was withdrew by " + name + ".");
                return true;
            } else {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(balance + " coins is/are in the account. " + name + " couldn't withdraw " + value + " coins.");
                return false;
            }
        }
    }

    public int checkBalance() {
        return balance;
    }
}
