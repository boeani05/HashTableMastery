import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Database {
    private final List<Entry>[] buckets;
    private final int capacity;
    private int size;

    public Database(int capacity) {
        this.capacity = capacity;

        this.buckets = new LinkedList[this.capacity];

        for (int i = 0; i < this.capacity; i++) {
            this.buckets[i] = new LinkedList<>();
        }

        this.size = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Entry> getBucket(int index) {
        return this.buckets[index];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}