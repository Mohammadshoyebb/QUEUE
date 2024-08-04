import java.util.Deque;
import java.util.LinkedList;

// Class to implement Queue using Deque
public class QueueUsingDeque {
    // Deque to store elements of the queue
    private Deque<Integer> deque = new LinkedList<>();

    // Enqueue element into the queue
    public void enqueue(int element) {
        deque.addLast(element); // Add element to the end of the deque
    }

    // Dequeue element from the queue
    public int dequeue() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return deque.pollFirst(); // Remove and return the front element of the deque
    }

    // Peek element from the queue
    public int peek() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return deque.peekFirst(); // Return the front element without removing it
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return deque.isEmpty(); // Check if the deque is empty
    }

    // Main method to demonstrate queue operations
    public static void main(String[] args) {
        // Create a queue
        QueueUsingDeque queue = new QueueUsingDeque();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Peek: " + queue.peek()); // Output: 2

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

        // Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 2
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 3

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}

