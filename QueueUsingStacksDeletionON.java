import java.util.Stack;

public class QueueUsingStacksDeletionON {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacksDeletionON() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation - O(1)
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation - O(N)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop the element from stack2
        return stack2.pop();
    }

    // Peek operation - O(N)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Peek the element from stack2
        return stack2.peek();
    }

    // Check if the queue is empty - O(1)
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacksDeletionON queue = new QueueUsingStacksDeletionON();

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
