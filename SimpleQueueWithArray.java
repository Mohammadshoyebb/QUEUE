public class SimpleQueueWithArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the queue
    public SimpleQueueWithArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue " + item);
            return;
        }
        rear = rear + 1; // Increment rear without wrapping around
        queue[rear] = item;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return -1;
        }
        int item = queue[front];
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        size--;
        return item;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot peek");
            return -1;
        }
        return queue[front];
    }

    // Get the size of the queue
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SimpleQueueWithArray queue = new SimpleQueueWithArray(5);
        queue.enqueue(10); // 10 enqueued to queue
        queue.enqueue(20); // 20 enqueued to queue
        queue.enqueue(30); // 30 enqueued to queue
        queue.enqueue(40); // 40 enqueued to queue
        queue.enqueue(50); // 50 enqueued to queue
        queue.enqueue(60); // Queue is full, cannot enqueue 60

        System.out.println("Front item is: " + queue.peek()); // Front item is: 10

        System.out.println("Dequeued: " + queue.dequeue()); // Dequeued: 10
        System.out.println("Dequeued: " + queue.dequeue()); // Dequeued: 20

        queue.enqueue(60); // 60 enqueued to queue
        System.out.println("Front item is: " + queue.peek()); // Front item is: 30

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("Queue size: " + queue.getSize()); // Queue size: 0
    }
}