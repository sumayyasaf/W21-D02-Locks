import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(double balance) {
        this.balance = balance;

    }

    public void deposit(double amount) {
        lock.lock(); //lock so only one thread at a time can change the balance

        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposit " + amount + " to " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdraw " + amount + " from " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " from " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                bankAccount.deposit(10);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 5; i++) {
                bankAccount.withdraw(20);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException _) {
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread.start();
        thread2.start();
    }
}


