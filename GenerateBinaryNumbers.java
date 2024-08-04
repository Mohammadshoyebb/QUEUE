/*
 * Generate Binary Numbers
 * Difficulty: Easy
 * Accuracy: 67.48%
 * Submissions: 47K+
 * Points: 2
 * 
 * Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.
 *
 * Example 1:
 * Input:
 * N = 2
 * Output: 
 * 1 10
 * Explanation: 
 * Binary numbers from 1 to 2 are 1 and 10.
 *
 * Example 2:
 * Input:
 * N = 5
 * Output: 
 * 1 10 11 100 101
 * Explanation: 
 * Binary numbers from 1 to 5 are 1, 10, 11, 100 and 101.
 * 
 * Your Task:
 * You only need to complete the function generate() that takes N as parameter and returns vector of strings denoting binary numbers.
 *
 * Expected Time Complexity : O(N log2N)
 * Expected Auxiliary Space : O(N log2N)
 *
 * Constraints:
 * 1 ≤ N ≤ 106
 */

 import java.util.*;

 public class GenerateBinaryNumbers {
     // Function to generate binary numbers from 1 to N using a queue
     static ArrayList<String> generate(int N) {
         ArrayList<String> list = new ArrayList<>();
         Queue<String> q = new LinkedList<>();
         
         q.add("1");
         while(N > 0){
             String temp = q.poll();
             list.add(temp);
             
             q.offer(temp + "0");
             q.offer(temp + "1");
             
             N--;
         }
         return list;
     }
     
     // Main method to test the function with examples
     public static void main(String[] args) {
         int[] testCases = {2, 5, 10, 15};
         
         for(int n : testCases) {
             System.out.println("Binary numbers from 1 to " + n + ":");
             ArrayList<String> result = generate(n);
             for(String binary : result) {
                 System.out.print(binary + " ");
             }
             System.out.println();
         }
     }
 }
 
