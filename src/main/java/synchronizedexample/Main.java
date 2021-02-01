package synchronizedexample;

public class Main {
    public static void main(String[] args) {
        SynchCount synchCount = new SynchCount();
        NonSynchCount nonSynchCount = new NonSynchCount();

        testCounter(synchCount);
        testCounter(nonSynchCount);
    }

    private static void testCounter(Counter counter) {
        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.inc();
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.dec();
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            incThread.start();
            decThread.start();
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
