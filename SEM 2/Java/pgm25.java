class Counter {
        private int count = 10;
 
        public synchronized void increment() {
            count++;
            System.out.println("Incremented: " + count);
        }
 
        public synchronized void decrement() {
            count -= 2;
            System.out.println("Decremented: " + count);
        }
 
        public synchronized int getCount() {
            return count;
        }
    }
 
class Incrementer implements Runnable {
        private Counter counter;
 
        public Incrementer(Counter counter) {
            this.counter = counter;
        }
 
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(200); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
class Decrementer implements Runnable {
        private Counter counter;
 
        public Decrementer(Counter counter) {
            this.counter = counter;
        }
 
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                counter.decrement();
                try {
                    Thread.sleep(300); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
public class pgm25{
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();
 
        Thread incrementThread = new Thread(new Incrementer(sharedCounter));
        Thread decrementThread = new Thread(new Decrementer(sharedCounter));
 
        incrementThread.start();
        decrementThread.start();
 
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        System.out.println("Final Counter Value: " + sharedCounter.getCount());
    }
}