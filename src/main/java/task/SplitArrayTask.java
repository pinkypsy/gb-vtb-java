package task;

import org.apache.logging.log4j.core.util.JsonUtils;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

public class SplitArrayTask {
    //    static final int SIZE = 10;
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public static void main(String[] args) {
        SplitArrayTask arrayTask = new SplitArrayTask();
        arrayTask.method1();
        arrayTask.method2();
    }

    void method1() {
        System.out.println("METHOD 1");
        Arrays.fill(arr, 1f);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math
                    .cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        //        for (float f : arr) {
        //            System.out.println(f);
        //        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    void method2() {
        System.out.println("METHOD 2");
        Arrays.fill(arr, 1f);
        long begin = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math
                        .cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("count1 is going");
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + HALF) / 5)
                        * Math.cos(0.2f + (i + HALF) / 5) * Math
                        .cos(0.4f + (i + HALF) / 2));
            }
            System.out.println("count2 is going");
        });

        thread1.start();
        thread2.start();

                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        //        for (float f : arr1) {
        //            System.out.println(f);
        //        }
        //        System.out.println();
        //        for (float f : arr2) {
        //            System.out.println(f);
        //        }
        //        System.out.println();
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        //                        for (float f : arr) {
        //                            System.out.println(f);
        //                        }
        System.out.println("ready");
        System.out.println(System.currentTimeMillis() - begin);
    }
}
