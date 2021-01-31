import fruits.Apple;
import fruits.FruitBox;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FruitBox<Orange> orangeBox = new FruitBox<>();
        orangeBox.addFruit(new Orange(10));
        orangeBox.addFruit(new Orange(20));
        orangeBox.addFruit(new Orange(5));

        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.addFruit(new Apple(3));
        appleBox.addFruit(new Apple(5));
        appleBox.addFruit(new Apple(1));

        float result = 0;
        for (int i = 0; i < orangeBox.getBoxSize(); i++) {
            result += orangeBox.get(i).getWeight();
        }


        System.out.println("Orange box: " + result);

        result = 0;
        for (int i = 0; i < appleBox.getBoxSize(); i++) {
            result += appleBox.get(i).getWeight();
        }
        System.out.println("Apple box: " + result);

    }

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <T> ArrayList<T> arrayToList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
