import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class BankingSystemMutex {
    public static void main(String[] args) {
        int numberClients = 11;
        int numberPlace = 3;
        int initialBalance = 110;
        int amountOfMoney = 10;
        BankAccount account = new BankAccount(initialBalance);
        Semaphore semaphore = new Semaphore(numberPlace);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= numberClients; i++) {
            exec.execute(new Client("Client number " + i, account, amountOfMoney, semaphore));
        }
        exec.shutdown();
    }
}
