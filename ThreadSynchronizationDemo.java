class NumberPrinter implements Runnable {
    private static final Object lock = new Object(); // Common lock for synchronization
    private String threadName;

    public NumberPrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " prints: " + i);
                try {
                    Thread.sleep(500); // Delay of 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NumberPrinter("Thread 1"));
        Thread t2 = new Thread(new NumberPrinter("Thread 2"));
        Thread t3 = new Thread(new NumberPrinter("Thread 3"));

        t1.start();
        t2.start();
        t3.start();
    }
}
