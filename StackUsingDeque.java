import java.util.Deque;
import java.util.LinkedList;

// Class to implement Stack using Deque
public class StackUsingDeque {
    // Deque to store elements of the stack
    private Deque<Integer> deque = new LinkedList<>();

    // Push element onto the stack
    public void push(int element) {
        deque.addLast(element); // Add element to the end of the deque
    }

    // Pop element from the stack
    public int pop() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return deque.pollLast(); // Remove and return the last element of the deque
    }

    // Peek element from the stack
    public int peek() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return deque.peekLast(); // Return the last element without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return deque.isEmpty(); // Check if the deque is empty
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        // Create a stack
        StackUsingDeque stack = new StackUsingDeque();

        // Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop elements
        System.out.println("Popped: " + stack.pop()); // Output: 3
        System.out.println("Peek: " + stack.peek()); // Output: 2

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Pop remaining elements
        System.out.println("Popped: " + stack.pop()); // Output: 2
        System.out.println("Popped: " + stack.pop()); // Output: 1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}
