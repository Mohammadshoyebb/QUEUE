/*
 * Question: Queue Reversal
 * 
 * Given a Queue Q containing N elements. The task is to reverse the Queue.
 * Your task is to complete the function rev() that reverses the N elements of the queue.
 * 
 * Example 1:
 * Input: 6
 * 4 3 1 10 2 6
 * Output: 6 2 10 1 3 4
 * Explanation: After reversing the given elements of the queue, the resultant queue will be 6 2 10 1 3 4.
 * 
 * Example 2:
 * Input: 4
 * 4 3 2 1
 * Output: 1 2 3 4
 * Explanation: After reversing the given elements of the queue, the resultant queue will be 1 2 3 4.
 * 
 * Constraints:
 * 1 ≤ N ≤ 105
 * 1 ≤ elements of Queue ≤ 105
 */

 import java.util.*;

public class QueueReversal {
     
     // Approach 1: Using a Stack
     public static Queue<Integer> revUsingStack(Queue<Integer> q) {
         Stack<Integer> stack = new Stack<>();
         
         // Push all elements of the queue into the stack
         while (!q.isEmpty()) {
             stack.push(q.poll());
         }
         
         // Pop all elements from the stack back into the queue
         while (!stack.isEmpty()) {
             q.offer(stack.pop());
         }
         
         return q;
     }
     
     // Approach 2: Using Recursion
     public static void reverseQueueRecursively(Queue<Integer> q) {
         if (q.isEmpty()) {
             return;
         }
         
         // Remove the front element
         int front = q.poll();
         
         // Reverse the remaining queue
         reverseQueueRecursively(q);
         
         // Add the removed element to the rear of the queue
         q.offer(front);
     }
     
     // Main function to test the queue reversal
     public static void main(String[] args) {
         // Test case 1
         Queue<Integer> q1 = new LinkedList<>(Arrays.asList(4, 3, 1, 10, 2, 6));
         Queue<Integer> reversedQueue1 = revUsingStack(q1);
         System.out.println("Reversed Queue (Using Stack): " + reversedQueue1); // Output: [6, 2, 10, 1, 3, 4]
         
         // Test case 2
         Queue<Integer> q2 = new LinkedList<>(Arrays.asList(4, 3, 2, 1));
         reverseQueueRecursively(q2);
         System.out.println("Reversed Queue (Using Recursion): " + q2); // Output: [1, 2, 3, 4]
         
         // Additional test case
         Queue<Integer> q3 = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
         Queue<Integer> reversedQueue3 = revUsingStack(q3);
         System.out.println("Reversed Queue (Using Stack): " + reversedQueue3); // Output: [50, 40, 30, 20, 10]
     }
 }
 
