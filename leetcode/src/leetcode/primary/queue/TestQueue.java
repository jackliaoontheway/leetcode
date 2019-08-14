package leetcode.primary.queue;

public class TestQueue {

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        System.out.print(queue.deQueue());
        System.out.print(queue.front());
    }


}
