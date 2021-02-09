package waitandnotify;

import java.util.Comparator;
import java.util.concurrent.Callable;

public class WaitNotifyExample {
    private final Object lock = new Object();
    private  char letter = 'A';

    public static void main(String[] args) {
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        new Thread(waitNotifyExample::printA).start();
        new Thread(waitNotifyExample::printB).start();

    }

    void printA() {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'A') {
                    System.out.println("\ncheck is A");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("A");
                letter = 'B';
                lock.notifyAll();
            }
        }
    }

    void printB() {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
            while (letter != 'B') {
                System.out.println("\ncheck is B");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.print("B");
                letter = 'A';
                lock.notifyAll();
            }
        }
    }
}
