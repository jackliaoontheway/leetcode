package leetcode.primary.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestJdkQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        //returning true upon success and throwing an IllegalStateException if no space is currently available.
        //queue.add("a");

        //Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
        //queue.offer("b");

        //Retrieves and removes the head of this queue
        //The remove() and poll() methods differ only in their behavior when the queue is empty:
        // the remove() method throws an exception, while the poll() method returns null
        //queue.poll();
        //queue.remove();

        //The element() and peek() methods return, but do not remove, the head of the queue.
        //queue.element(); // if the queue is empty will throw java.util.NoSuchElementException
        //queue.peek(); // if the queue is empty return null

    }

}
