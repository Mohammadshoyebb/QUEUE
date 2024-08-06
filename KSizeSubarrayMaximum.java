/**
 * K Sized Subarray Maximum
 * Difficulty: Medium
 * Accuracy: 26.04%
 * Submissions: 316K+
 * Points: 4
 *
 * Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
 *
 * Example 1:
 * Input: N = 9, K = 3
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * Output:
 * 3 3 4 5 5 5 6
 * Explanation:
 * 1st contiguous subarray = {1 2 3} Max = 3
 * 2nd contiguous subarray = {2 3 1} Max = 3
 * 3rd contiguous subarray = {3 1 4} Max = 4
 * 4th contiguous subarray = {1 4 5} Max = 5
 * 5th contiguous subarray = {4 5 2} Max = 5
 * 6th contiguous subarray = {5 2 3} Max = 5
 * 7th contiguous subarray = {2 3 6} Max = 6
 *
 * Example 2:
 * Input: N = 10, K = 4
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * Output:
 * 10 10 10 15 15 90 90
 * Explanation:
 * 1st contiguous subarray = {8 5 10 7}, Max = 10
 * 2nd contiguous subarray = {5 10 7 9}, Max = 10
 * 3rd contiguous subarray = {10 7 9 4}, Max = 10
 * 4th contiguous subarray = {7 9 4 15}, Max = 15
 * 5th contiguous subarray = {9 4 15 12}, Max = 15
 * 6th contiguous subarray = {4 15 12 90}, Max = 90
 * 7th contiguous subarray = {15 12 90 13}, Max = 90
 *
 * Constraints:
 * 1 ≤ N ≤ 10^6
 * 1 ≤ K ≤ N
 * 0 ≤ arr[i] ≤ 10^9
 *
 * Your Task:
 * You don't need to read input or print anything. Complete the function max_of_subarrays() which takes the array, N and K as input parameters and returns a list of integers denoting the maximum of every contiguous subarray of size K.
 * 
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(k)
 */

 import java.util.*;

 public class KSizeSubarrayMaximum {
     public static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
         ArrayDeque<Integer> dq = new ArrayDeque<>();
         ArrayList<Integer> result = new ArrayList<>();
 
         for (int i = 0; i < n; i++) {
             // Remove elements not within the sliding window
             if (!dq.isEmpty() && dq.peek() == i - k) {
                 dq.poll();
             }
 
             // Remove elements not greater than current element
             while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                 dq.pollLast();
             }
 
             dq.offer(i);
 
             // Add to result once the first window is fully traversed
             if (i >= k - 1) {
                 result.add(arr[dq.peek()]);
             }
         }
 
         return result;
     }
 
     public static void main(String[] args) {
         int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
         int N1 = 9;
         int K1 = 3;
         System.out.println(max_of_subarrays(arr1, N1, K1)); // [3, 3, 4, 5, 5, 5, 6]
 
         int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
         int N2 = 10;
         int K2 = 4;
         System.out.println(max_of_subarrays(arr2, N2, K2)); // [10, 10, 10, 15, 15, 90, 90]
     }
 }
 
