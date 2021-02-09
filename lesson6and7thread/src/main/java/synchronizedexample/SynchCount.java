package synchronizedexample;

public class SynchCount implements Counter {
    int count;

    public synchronized void inc(){
        count++;
    }

    public synchronized void dec(){
        count--;
    }

    public int getCount() {
        return count;
    }
}
