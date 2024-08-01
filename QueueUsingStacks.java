/**
 * 232. Implement Queue using Stacks
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * 
 * Implement the MyQueue class:
 * 
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * 
 * Notes:
 * 
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * 
 * Example 1:
 * 
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * 
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * 
 * Constraints:
 * 
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 * 
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */

 import java.util.Stack;

 public class QueueUsingStacks {
     // Stack to hold the elements for enqueue operations
     private Stack<Integer> stack1;
     // Stack to hold the elements for dequeue operations
     private Stack<Integer> stack2;
 
     // Constructor to initialize the stacks
     public QueueUsingStacks() {
         stack1 = new Stack<>();
         stack2 = new Stack<>();
     }
 
     // Push element x to the back of the queue
     public void push(int x) {
         stack1.push(x);
     }
 
     // Removes the element from the front of the queue and returns it
     public int pop() {
         // If stack2 is empty, move elements from stack1 to stack2
         if (stack2.isEmpty()) {
             while (!stack1.isEmpty()) {
                 stack2.push(stack1.pop());
             }
         }
         // Return the top element from stack2
         return stack2.pop();
     }
 
     // Get the front element
     public int peek() {
         // If stack2 is empty, move elements from stack1 to stack2
         if (stack2.isEmpty()) {
             while (!stack1.isEmpty()) {
                 stack2.push(stack1.pop());
             }
         }
         // Return the top element from stack2 without removing it
         return stack2.peek();
     }
 
     // Return whether the queue is empty
     public boolean empty() {
         return stack1.isEmpty() && stack2.isEmpty();
     }
 
     public static void main(String[] args) {
         // Create a queue using stacks
         QueueUsingStacks myQueue = new QueueUsingStacks();
         
         // Test cases
         myQueue.push(1); // queue is: [1]
         myQueue.push(2); // queue is: [1, 2]
         
         System.out.println("Peek: " + myQueue.peek()); // return 1
         System.out.println("Pop: " + myQueue.pop()); // return 1, queue is [2]
         System.out.println("Empty: " + myQueue.empty()); // return false
     }
 }
 
