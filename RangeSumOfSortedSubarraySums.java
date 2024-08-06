/*
 1508. Range Sum of Sorted Subarray Sums
Solved
Medium
Topics
Companies
Hint
You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.

 

Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13 
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13. 
Example 2:

Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
Example 3:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50
 

Constraints:

n == nums.length
1 <= nums.length <= 1000
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2
 */

import java.util.*;

public class RangeSumOfSortedSubarraySums {
    
    // Optimized approach using Priority Queue
    public int rangeSumOptimized(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // Initialize the priority queue with each element of nums and their corresponding index
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int sum = 0;

        // Iterate to find the sums in the priority queue
        for (int index = 0; index < right; index++) {
            int[] cur = pq.poll();

            // Add to sum if within the range [left, right]
            if (index >= left - 1) {
                sum = (sum + cur[0]) % mod;
            }

            // If there is a next element in the array, add the new subarray sum to the priority queue
            if (cur[1] + 1 < n) {
                cur[1]++;
                cur[0] = cur[0] + nums[cur[1]];
                pq.offer(cur);
            }
        }

        return sum;
    }

    // Brute force approach
    public int rangeSumBruteForce(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        List<Integer> subarraySums = new ArrayList<>();

        // Calculate all possible subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        // Sort the subarray sums
        Collections.sort(subarraySums);

        // Calculate the sum from left to right indices
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % mod;
        }

        return result;
    }

    public static void main(String[] args) {
        RangeSumOfSortedSubarraySums solution = new RangeSumOfSortedSubarraySums();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        int n1 = nums1.length;
        int left1 = 1;
        int right1 = 5;
        System.out.println("Optimized Approach: " + solution.rangeSumOptimized(nums1, n1, left1, right1)); // Output: 13
        System.out.println("Brute Force Approach: " + solution.rangeSumBruteForce(nums1, n1, left1, right1)); // Output: 13

        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        int n2 = nums2.length;
        int left2 = 3;
        int right2 = 4;
        System.out.println("Optimized Approach: " + solution.rangeSumOptimized(nums2, n2, left2, right2)); // Output: 6
        System.out.println("Brute Force Approach: " + solution.rangeSumBruteForce(nums2, n2, left2, right2)); // Output: 6

        // Example 3
        int[] nums3 = {1, 2, 3, 4};
        int n3 = nums3.length;
        int left3 = 1;
        int right3 = 10;
        System.out.println("Optimized Approach: " + solution.rangeSumOptimized(nums3, n3, left3, right3)); // Output: 50
        System.out.println("Brute Force Approach: " + solution.rangeSumBruteForce(nums3, n3, left3, right3)); // Output: 50
    }
}
