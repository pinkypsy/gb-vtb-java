package fruits;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List <T> box = new ArrayList<>();

    public void addFruit (T fruit){
        box.add(fruit);
    }

    double getBoxWeight(double unitWeight, int quantity){
        return unitWeight * quantity;
    }

}
