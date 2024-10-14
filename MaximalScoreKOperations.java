/*
    2530. Maximal Score After Applying K Operations

    You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

    In one operation:
    - Choose an index i such that 0 <= i < nums.length,
    - Increase your score by nums[i], and
    - Replace nums[i] with ceil(nums[i] / 3).

    Return the maximum possible score you can attain after applying exactly k operations.

    The ceiling function ceil(val) is the least integer greater than or equal to val.

    Example 1:
    Input: nums = [10,10,10,10,10], k = 5
    Output: 50
    Explanation: Apply the operation to each array element exactly once. 
    The final score is 10 + 10 + 10 + 10 + 10 = 50.

    Example 2:
    Input: nums = [1,10,3,3,3], k = 3
    Output: 17
    Explanation: You can do the following operations:
    Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
    Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
    Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
    The final score is 10 + 4 + 3 = 17.

    Constraints:
    - 1 <= nums.length, k <= 10^5
    - 1 <= nums[i] <= 10^9
*/

import java.util.PriorityQueue;

public class MaximalScoreKOperations {

    public long maxKelements(int[] nums, int k) {

        
    /*

        // Creating a max-priority queue using reverseOrder()
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

    */
        // Max-Heap to keep track of the largest numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Comparator to implement max-heap

        // Add all elements of nums into the max-heap
        for (int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0; // Variable to keep track of the total score

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the largest element from the max-heap
            int maxElement = maxHeap.poll();
            
            // Add the current largest element to the score
            score += maxElement;

            // Replace the extracted element with ceil(maxElement / 3.0) and reinsert into the heap
            maxHeap.offer((int) Math.ceil(maxElement / 3.0));
        }

        // Return the final score after k operations
        return score;
    }

    public static void main(String[] args) {
        MaximalScoreKOperations solution = new MaximalScoreKOperations();

        // Test case 1
        int[] nums1 = {10, 10, 10, 10, 10};
        int k1 = 5;
        System.out.println("Maximal Score: " + solution.maxKelements(nums1, k1)); // Output: 50

        // Test case 2
        int[] nums2 = {1, 10, 3, 3, 3};
        int k2 = 3;
        System.out.println("Maximal Score: " + solution.maxKelements(nums2, k2)); // Output: 17
    }
}


//======================================FASTER APPROACH===========================================

/*
 
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : nums){
            pq.add(i);
        }
        long ans = 0;
        while(k-- > 0){
            int n = pq.poll();
            ans += n;
            pq.offer((n + 2)/ 3);
        }
        return ans;
    }
}

 */

//===========================explanation===================================

 /*
  

The loop runs for k iterations (i.e., performs k operations):

    Extract the largest element from the max-heap using pq.poll(). 
    This ensures the largest number is processed first.

    Add the extracted element to the score (ans += n).
    Replace the element with ceil(n / 3):

    The formula (n + 2) / 3 effectively simulates ceil(n / 3). 
    This works because adding 2 before integer division mimics the ceiling effect for division by 3.
    Insert the updated element back into the heap using pq.offer() so that it can be considered in future operations if necessary.


  */