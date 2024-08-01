import java.util.Stack;

public class QueueUsingStacksInsertionON {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacksInsertionON() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation - O(N)
    public void enqueue(int x) {
        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Push item into stack1
        stack1.push(x);

        // Move all elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // Dequeue operation - O(1)
    public int dequeue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.pop();
    }

    // Peek operation - O(1)
    public int peek() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.peek();
    }

    // Check if the queue is empty - O(1)
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacksInsertionON queue = new QueueUsingStacksInsertionON();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Display the front element
        System.out.println("Peek: " + queue.peek()); // Output: 1

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 2

        // Display the front element
        System.out.println("Peek: " + queue.peek()); // Output: 3

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: false

        // Dequeue the remaining element
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 3

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: true
    }
}
