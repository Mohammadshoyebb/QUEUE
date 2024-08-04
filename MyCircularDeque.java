/*
 641. Design Circular Deque
Attempted
Medium
Topics
Companies
Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.
 

Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
 

Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
 */

 public class MyCircularDeque {
    private int[] deque;
    private int front, rear, size, capacity;

    // Initialize the deque with maximum size k
    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add an item at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity; // Move front to the previous position
        deque[front] = value;
        size++;
        if (size == 1) { // Special case: when the first element is added, set rear to front
            rear = front;
        }
        return true;
    }

    // Add an item at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity; // Move rear to the next position
        deque[rear] = value;
        size++;
        return true;
    }

    // Delete an item from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity; // Move front to the next position
        size--;
        return true;
    }

    // Delete an item from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity; // Move rear to the previous position
        size--;
        return true;
    }

    // Get the front item from the deque
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    // Get the last item from the deque
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return true
        System.out.println(myCircularDeque.insertLast(2));  // return true
        System.out.println(myCircularDeque.insertFront(3)); // return true
        System.out.println(myCircularDeque.insertFront(4)); // return false, the queue is full
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return true
        System.out.println(myCircularDeque.deleteLast());   // return true
        System.out.println(myCircularDeque.insertFront(4)); // return true
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}
