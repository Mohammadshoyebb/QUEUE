public class CircularQueueWithArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the queue
    public CircularQueueWithArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Method to get the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the current size of the queue
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CircularQueueWithArray queue = new CircularQueueWithArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This should print "Queue is full"

        System.out.println("Front element is: " + queue.peek());
        System.out.println("Removed element is: " + queue.dequeue());
        System.out.println("Front element is: " + queue.peek());
        System.out.println("Queue size is: " + queue.getSize());

        queue.enqueue(60);
        System.out.println("Front element is: " + queue.peek());
    }
}
