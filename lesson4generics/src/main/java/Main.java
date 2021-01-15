import fruits.Apple;
import fruits.Box;
import fruits.Fruit;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList("Z", "BBB", "B", "a", "c", "b", "A"));
        System.out.println(list);

        String[] array = { "Z", "BBB", "B", "a", "c", "b", "A" };

        swap(array, 1, 3);
        System.out.println(Arrays.toString(array));

        System.out.println(arrayToList(array).getClass());

        Box <Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

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
