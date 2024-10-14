// 703. Kth Largest Element in a Stream
// Design a class to find the kth largest element in a stream. 
// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Implement the KthLargestElementInAStream class:

// KthLargestElementInAStream(int k, int[] nums) 
// Initializes the object with the integer k and the stream of integers nums.

// int add(int val) 
// Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

// Example 1:
// Input:
// ["KthLargestElementInAStream", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output:
// [null, 4, 5, 5, 8, 8]

// Explanation:
// KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, [4, 5, 8, 2]);
// kthLargest.add(3);   // return 4
// kthLargest.add(5);   // return 5
// kthLargest.add(10);  // return 5
// kthLargest.add(9);   // return 8
// kthLargest.add(4);   // return 8

// Constraints:
// 1 <= k <= 10^4
// 0 <= nums.length <= 10^4
// -10^4 <= nums[i] <= 10^4
// -10^4 <= val <= 10^4
// At most 10^4 calls will be made to add.
// It is guaranteed that there will be at least k elements in the array when you search for the kth element.

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    // Efficient approach using a min-heap (PriorityQueue)
    private PriorityQueue<Integer> minHeap;
    private int k;

    // Initialize the object with the integer k and the stream of integers nums.
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    // Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    // Alternative approach using custom heap implementation
    private int size = 0;
    private int[] heap;

    public void initializeCustomHeap(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k + 1];
        for (int num : nums) {
            addUsingCustomHeap(num);
        }
    }

    public int addUsingCustomHeap(int val) {
        if (size == k) {
            if (val < heap[1]) {
                return heap[1];
            }
            pop();
        }

        heap[++size] = val;

        int index = size;
        int parent = size / 2;

        while (heap[parent] > heap[index] && index > 1) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = parent / 2;
        }

        return heap[1];
    }

    private void pop() {
        heap[1] = heap[size--];

        int index = 1;
        while (index <= size / 2) {
            int left = index * 2;
            int right = (index * 2) + 1;

            if (heap[index] > heap[left] || heap[index] > heap[right]) {
                if (heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Using PriorityQueue approach
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(k, nums);

        System.out.println(kthLargest.add(3));  // return 4
        System.out.println(kthLargest.add(5));  // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9));  // return 8
        System.out.println(kthLargest.add(4));  // return 8

        // Using custom heap implementation
        KthLargestElementInAStream customKthLargest = new KthLargestElementInAStream(k, new int[]{});
        customKthLargest.initializeCustomHeap(k, nums);

        System.out.println(customKthLargest.addUsingCustomHeap(3));  // return 4
        System.out.println(customKthLargest.addUsingCustomHeap(5));  // return 5
        System.out.println(customKthLargest.addUsingCustomHeap(10)); // return 5
        System.out.println(customKthLargest.addUsingCustomHeap(9));  // return 8
        System.out.println(customKthLargest.addUsingCustomHeap(4));  // return 8
    }
}
