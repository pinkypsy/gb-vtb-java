
public class ChairSynchroExample {
    public static void main(String[] args) {
        Object chair1 = new Object();
        Object chair2 = new Object();

        Thread human1 = new Thread(() -> {
            System.out.println("human1 подошел к стулу1");
            synchronized (chair1){
                System.out.println("human1 сел на стул1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("human1 встал со стула1");
            }
        });

        Thread human2 = new Thread(() -> {
            System.out.println("human2 подошел к стулу1");
            synchronized (chair1){
                System.out.println("human2 сел на стул1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("human2 встал со стула1");
            }
        });

        Thread human3 = new Thread(() -> {
            System.out.println("human3 подошел к стулу1");
            synchronized (chair1){
                System.out.println("human3 сел на стул1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("human3 встал со стула1");
            }
        });

        Thread human4 = new Thread(() -> {
            System.out.println("human4 подошел к стулу2");
            synchronized (chair2){
                System.out.println("human4 сел на стул2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("human4 встал со стула2");
            }
        });
        human1.start();
        human2.start();
        human3.start();
        human4.start();
    }
}
