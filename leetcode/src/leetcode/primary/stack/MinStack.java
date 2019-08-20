package leetcode.primary.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(-1);
        obj.pop();
        obj.push(2);
        obj.push(-1);
        System.out.print(obj.getMin());
    }

    private List<Integer> data;

    public MinStack() {
        this.data = new ArrayList<>();
    }

    public void push(int x) {
        this.data.add(x);
    }

    public void pop() {
        if (!data.isEmpty()) {
            this.data.remove(data.size() - 1);
        }
    }

    public int top() {
        if (data.isEmpty()) {
            return -1;
        }
        return this.data.get(data.size() - 1);
    }

    public int getMin() {
        if(this.data.size() == 0) {
            return -1;
        }
        int minimalItem = this.data.get(0);
        for(int item : this.data) {
            if(minimalItem > item) {
                minimalItem = item;
            }
        }
        return minimalItem;
    }

}
