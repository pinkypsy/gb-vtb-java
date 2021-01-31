package fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FruitBox<T extends Fruit>  {
    private List <T> box = new ArrayList<>();
    private int boxSize;

    public FruitBox(T... fruits){
        this.box = new ArrayList<>(Arrays.asList(fruits));
    }

    public void addFruit (T... fruits){
        box.addAll(Arrays.asList(fruits));
        boxSize++;
        HashMap
    }

    public T get(int i){
        return box.get(i);
    }

    public int getBoxSize() {
        return boxSize;
    }

    //    public double getBoxWeight(){
//        for (T t : box) {
//
//        }
//        return box.size();
////        return unitWeight * quantity;
//    }

}
