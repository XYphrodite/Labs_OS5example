//package BankingSystemMutex;


import java.util.concurrent.Semaphore;

public class Client implements Runnable{
    private final String name;
    private final BankAccount account;
    private final int amountOfMoney;
    private final Semaphore semaphore;

    public Client(String name, BankAccount account, int amountOfMoney, Semaphore semaphore) {
        this.name = name;
        this.account = account;
        this.amountOfMoney = amountOfMoney;
        this.semaphore = semaphore;
    }
    public void run(){
        /*while (true){
            System.out.println(name+" initiated withdrawal.");
            try {
                if (!account.takeMoney(amountOfMoney,name)){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println(name+" is/are standing next to entrance in cab");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" came into cab and initiated withdrawal of coins");
        try {
            account.takeMoney(amountOfMoney,name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
