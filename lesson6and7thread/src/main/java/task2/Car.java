package task2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicInteger;

import static task2.MainClass.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    public volatile static boolean winnerAvailable = false;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private static AtomicInteger finishedPos = new AtomicInteger(1);

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            settingUpLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            Stage currentStage = race.getStages().get(i);
            currentStage.go(this);
        }
        if (!winnerAvailable) {
            winnerAvailable = true;
            System.out.println(
                    this.name + " WIN finished at position #"
                            + finishedPos.getAndIncrement());
        } else {
            System.out.println(this.name + " finished at position: "
                    + finishedPos.getAndIncrement());
        }
        allCarsArrivedLatch.countDown();
    }
}