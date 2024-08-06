// Find median in a stream
// Difficulty: Hard
// Accuracy: 30.34%
// Submissions: 119K+
// Points: 8
// Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
//
// Example 1:
// Input: N = 4, X[] = 5,15,1,3
// Output: 5, 10, 5, 4
// Explanation: Flow in stream : 5, 15, 1, 3 
// 5 goes to stream --> median 5 (5) 
// 15 goes to stream --> median 10 (5,15) 
// 1 goes to stream --> median 5 (5,15,1) 
// 3 goes to stream --> median 4 (5,15,1 3) 
//
// Example 2:
// Input: N = 3, X[] = 5,10,15
// Output: 5, 7.5, 10
// Explanation: Flow in stream : 5, 10, 15
// 5 goes to stream --> median 5 (5) 
// 10 goes to stream --> median 7.5 (5,10) 
// 15 goes to stream --> median 10 (5,10,15) 
//
// Your Task:
// You are required to complete the class MedianFinder. 
// It should have 2 data members to represent 2 heaps. 
// It should have the following member functions:
// - insertHeap() which takes x as input and inserts it into the heap, the function should then call balanceHeaps() to balance the new heap.
// - balanceHeaps() does not take any arguments. It is supposed to balance the two heaps.
// - getMedian() does not take any arguments. It should return the current median of the stream.
//
// Expected Time Complexity : O(nlogn)
// Expected Auxiliary Space : O(n)
//
// Constraints:
// 1 <= N <= 10^6
// 1 <= x <= 10^6

import java.util.PriorityQueue;
import java.util.Collections;

public class FindMedianInAStreamGFG {
    // Function to insert heap.
    private static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> min = new PriorityQueue<>();

    public static void insertHeap(int x) {
        // Add the number to one of the heaps
        if (max.size() == 0 || max.peek() >= x) {
            max.offer(x);
        } else {
            min.offer(x);
        }

        // Balance the heaps after insertion
        balanceHeaps();
    }

    // Function to balance heaps.
    public static void balanceHeaps() {
        if (max.size() > min.size() + 1) {
            min.offer(max.poll());
        } else if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    // Function to return Median.
    public static double getMedian() {
        if (max.size() == min.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] stream = {5, 15, 1, 3};
        for (int num : stream) {
            insertHeap(num);
            System.out.println(getMedian());
        }

        // Another example
        int[] stream2 = {5, 10, 15};
        for (int num : stream2) {
            insertHeap(num);
            System.out.println(getMedian());
        }
    }
}
