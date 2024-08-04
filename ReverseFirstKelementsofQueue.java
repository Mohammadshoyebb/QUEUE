/*
 * Reverse First K elements of Queue
 * Difficulty: Easy
 * Accuracy: 81.28%
 * Submissions: 127K+
 * Points: 2
 * 
 * Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, 
 * leaving the other elements in the same relative order.
 *
 * Only following standard operations are allowed on queue:
 * - enqueue(x) : Add an item x to rear of queue
 * - dequeue() : Remove an item from front of queue
 * - size() : Returns number of elements in queue.
 * - front() : Finds front item.
 *
 * Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.
 *
 * Example 1:
 * Input: 5 3
 * 1 2 3 4 5
 * Output: 3 2 1 4 5
 * Explanation: 
 * After reversing the given input from the 3rd position the resultant output will be 3 2 1 4 5.
 * 
 * Example 2:
 * Input: 4 4
 * 4 3 2 1
 * Output: 1 2 3 4
 * Explanation: 
 * After reversing the given input from the 4th position the resultant output will be 1 2 3 4.
 * 
 * Your Task:
 * Complete the provided function modifyQueue() that takes queue and K as parameters and returns a modified queue.
 * The printing is done automatically by the driver code.
 * 
 * Expected Time Complexity : O(N)
 * Expected Auxiliary Space : O(K)
 * 
 * Constraints:
 * 1 <= K <= N <= 105
 */

 import java.util.*;

 public class ReverseFirstKelementsofQueue {
     // Function to reverse the first K elements of the queue
     public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
         if (q == null || k <= 0 || k > q.size()) {
             return q;
         }
 
         // Step 1: Use a stack to reverse the first K elements
         Stack<Integer> stack = new Stack<>();
         for (int i = 0; i < k; i++) {
             stack.push(q.poll());
         }
 
         // Step 2: Enqueue the reversed elements back into the queue
         while (!stack.isEmpty()) {
             q.offer(stack.pop());
         }
 
         // Step 3: Move the remaining elements from the front to the rear to maintain order
         for (int i = 0; i < q.size() - k; i++) {
             q.offer(q.poll());
         }
 
         return q;
     }
 
     public static void main(String[] args) {
         Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
         int k = 3;
         Queue<Integer> result = modifyQueue(queue, k);
         System.out.println(result); // Output: [3, 2, 1, 4, 5]
     }
 }
 