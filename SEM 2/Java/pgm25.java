// SHARED ACCOUNT
class Account {
    private int balance = 1000;

    public Account() {
        System.out.println("Initial Balance: " + balance);
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
        notify();
    }

    public synchronized void withdraw(int amount) {

        // Case 1: transaction not possible
        if (amount > balance) {
            System.out.println("Transaction not possible! Insufficient balance.");
        }

        // Wait for deposit if needed
        while (balance < amount) {
            System.out.println("Waiting for deposit...");
            try { wait(); } catch (InterruptedException e) {}
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
    }
}

// DEPOSITOR THREAD
class Depositor implements Runnable {
    private Account acc;

    Depositor(Account acc) {
        this.acc = acc;
    }

    public void run() {
        acc.deposit(500);
    }
}

// WITHDRAWER THREAD
class Withdrawer implements Runnable {
    private Account acc;

    Withdrawer(Account acc) {
        this.acc = acc;
    }

    public void run() {
        acc.withdraw(1200);
    }
}

// MAIN CLASS
public class pgm25 {
    public static void main(String[] args) {

        Account acc = new Account();

        Thread t1 = new Thread(new Withdrawer(acc));
        Thread t2 = new Thread(new Depositor(acc));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("Transaction Completed!");
    }
}
/*
Initial Balance: 1000
Transaction not possible! Insufficient balance.
Waiting for deposit...
Deposited: 500 | Balance: 1500
Withdrawn: 1200 | Balance: 300
Transaction Completed!
*/