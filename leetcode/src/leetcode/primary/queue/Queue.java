package leetcode.primary.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private List<Integer> data;
    private int startIndex;

    public Queue() {
        this.data = new ArrayList<>();
        this.startIndex = 0;
    }

    public boolean enQueue(int item) {
        this.data.add(item);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.startIndex++;
        return true;
    }

    public int front() {
        return this.data.get(startIndex);
    }

    public boolean isEmpty() {
        return this.data.size() <= startIndex;
    }


}
