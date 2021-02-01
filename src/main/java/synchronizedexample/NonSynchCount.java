package synchronizedexample;

public class NonSynchCount implements Counter {
    private int count;

    public void inc(){
        count++;
    }

    public void dec(){
        count--;
    }

    public int getCount() {
        return count;
    }
}
