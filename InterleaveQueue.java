/*
 * Question: Interleave the First Half of the Queue with Second Half
 * 
 * You are given a queue Q of N integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.
 * 
 * Example 1:
 * Input: N = 4, Q = {2,4,3,1}
 * Output: {2,3,4,1}
 * Explanation: After the mentioned rearrangement of the first half and second half, our final queue will be {2,3,4,1}.
 * 
 * Example 2:
 * Input: N = 2, Q = {3,5}
 * Output: {3,5}
 * Explanation: After the mentioned rearrangement of the first half and second half, our final queue will be {3,5}.
 * 
 * Constraints:
 * 2 <= N <= 105
 * N is even
 * 1 <= Elements of Queue <= 103
 * Sum of N over all test cases doesn't exceeds 106
 */

 import java.util.*;

public class InterleaveQueue {
     // Function to rearrange the queue by interleaving the first half with the second half
     public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
         int half = N / 2;
         ArrayList<Integer> list = new ArrayList<>();
         
         // Queue to hold the first half of the elements
         Queue<Integer> qh = new LinkedList<>();
         
         // Populate qh with the first half of the elements
         while (half > 0) {
             half--;
             qh.offer(q.poll());
         }
         
         // Interleave elements from qh and q into the result list
         while (N > 0) {
             list.add(qh.poll()); // Add element from the first half
             list.add(q.poll());  // Add element from the second half
             N -= 2;
         }
         return list;
     }
 
     public static void main(String[] args) {
         // Test case 1
         Queue<Integer> q1 = new LinkedList<>(Arrays.asList(2, 4, 3, 1));
         ArrayList<Integer> result1 = rearrangeQueue(4, q1);
         System.out.println(result1); // Output: [2, 3, 4, 1]
         
         // Test case 2
         Queue<Integer> q2 = new LinkedList<>(Arrays.asList(3, 5));
         ArrayList<Integer> result2 = rearrangeQueue(2, q2);
         System.out.println(result2); // Output: [3, 5]
         
         // Additional test case
         Queue<Integer> q3 = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
         ArrayList<Integer> result3 = rearrangeQueue(6, q3);
         System.out.println(result3); // Output: [10, 40, 20, 50, 30, 60]
     }
 }
 
