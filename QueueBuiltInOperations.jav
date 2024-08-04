import java.util.*;

public class QueueBuiltInOperations{

    public static void demonstrateQueueOperations() {
        // 1. Creation and Initialization
        Queue<String> queue = new LinkedList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));
        System.out.println("Initial queue: " + queue);

        // 2. Adding Elements
        queue.add("Fig"); // Adds "Fig" at the end of the queue
        queue.offer("Grape"); // Adds "Grape" at the end of the queue
        System.out.println("After adding elements: " + queue);

        // 3. Removing Elements
        String removedElement = queue.remove(); // Removes and returns the first element in the queue
        System.out.println("Removed element: " + removedElement);
        String pollElement = queue.poll(); // Removes and returns the first element in the queue, returns null if empty
        System.out.println("Polled element: " + pollElement);
        System.out.println("Queue after removals: " + queue);

        // 4. Accessing Elements
        String firstElement = queue.peek(); // Retrieves, but does not remove, the first element of the queue
        System.out.println("First element (peek): " + firstElement);

        // 5. Size and Capacity
        int size = queue.size(); // Gets the number of elements in the queue
        boolean isEmpty = queue.isEmpty(); // Checks if the queue is empty
        System.out.println("Size of queue: " + size);
        System.out.println("Is the queue empty? " + isEmpty);

        // 6. Checking for Presence
        boolean containsCherry = queue.contains("Cherry"); // Checks if "Cherry" is in the queue
        System.out.println("Queue contains 'Cherry': " + containsCherry);

        // 7. Clearing the Queue
        queue.clear(); // Removes all elements from the queue
        System.out.println("Queue after clearing: " + queue);

        // 8. Adding Elements Again
        queue.addAll(Arrays.asList("Java", "Python", "C++", "JavaScript"));
        System.out.println("Queue before iteration: " + queue);

        // 9. Iteration
        System.out.println("Iterating using enhanced for loop:");
        for (String item : queue) {
            System.out.println(item);
        }

        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 10. Convert Queue to Array
        String[] array = queue.toArray(new String[0]); // Converts the queue to an array
        System.out.println("Array: " + Arrays.toString(array));

        // 11. Reverse the Queue (Using Stack)
        Stack<String> stack = new Stack<>();
        stack.addAll(queue); // Push all elements to stack
        Queue<String> reversedQueue = new LinkedList<>();
        while (!stack.isEmpty()) {
            reversedQueue.add(stack.pop()); // Pop all elements from stack and add them to the new queue
        }
        System.out.println("Reversed queue: " + reversedQueue);

        // 12. Interleave First and Second Half of the Queue
        interleaveQueue(reversedQueue);

        // 13. Enqueue Operations with Different Types
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        System.out.println("Integer Queue: " + integerQueue);

        // 14. Merge Two Queues
        Queue<String> queue2 = new LinkedList<>(Arrays.asList("Ruby", "Swift"));
        queue.addAll(queue2);
        System.out.println("Merged queue: " + queue);

        // 15. Sub-Queue
        Queue<String> subQueue = new LinkedList<>(queue);
        while (subQueue.size() > 2) {
            subQueue.poll(); // Remove elements until size is 2
        }
        System.out.println("Sub-queue with 2 elements: " + subQueue);
    }

    private static void interleaveQueue(Queue<String> q) {
        int size = q.size();
        int half = size / 2;
        Queue<String> firstHalf = new LinkedList<>();
        Queue<String> secondHalf = new LinkedList<>();

        // Split the queue into two halves
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.poll());
        }
        while (!q.isEmpty()) {
            secondHalf.add(q.poll());
        }

        // Interleave the two halves
        Queue<String> interleavedQueue = new LinkedList<>();
        while (!firstHalf.isEmpty() || !secondHalf.isEmpty()) {
            if (!firstHalf.isEmpty()) {
                interleavedQueue.add(firstHalf.poll());
            }
            if (!secondHalf.isEmpty()) {
                interleavedQueue.add(secondHalf.poll());
            }
        }
        System.out.println("Interleaved queue: " + interleavedQueue);
    }

    public static void main(String[] args) {
        demonstrateQueueOperations();
    }
}
