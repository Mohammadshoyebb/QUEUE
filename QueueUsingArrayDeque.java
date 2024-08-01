import java.util.ArrayDeque;
import java.util.Queue;

public class QueueUsingArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        // Adding elements to the queue
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        // Displaying the queue
        System.out.println("Queue: " + queue);
        
        // Removing elements from the queue
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue after poll: " + queue);
        
        // Peeking the front element of the queue
        System.out.println("Peek: " + queue.peek());
    }
}

