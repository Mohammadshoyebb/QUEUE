import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DEQUEOperations {
    public static void demonstrateDequeOperations() {
        // 1. Creation and Initialization
        Deque<String> deque = new LinkedList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));
        System.out.println("Initial deque: " + deque);

        // 2. Adding Elements
        deque.addFirst("Fig"); // Adds "Fig" to the front of the deque
        deque.addLast("Grape"); // Adds "Grape" to the end of the deque
        deque.offerFirst("Honeydew"); // Adds "Honeydew" to the front of the deque
        deque.offerLast("Ivy"); // Adds "Ivy" to the end of the deque
        System.out.println("After adding elements: " + deque);

        // 3. Removing Elements
        String removedFirst = deque.removeFirst(); // Removes and returns the first element
        System.out.println("Removed first element: " + removedFirst);
        String removedLast = deque.removeLast(); // Removes and returns the last element
        System.out.println("Removed last element: " + removedLast);
        String polledFirst = deque.pollFirst(); // Removes and returns the first element, returns null if empty
        System.out.println("Polled first element: " + polledFirst);
        String polledLast = deque.pollLast(); // Removes and returns the last element, returns null if empty
        System.out.println("Polled last element: " + polledLast);
        System.out.println("Deque after removals: " + deque);

        // 4. Accessing Elements
        String firstElement = deque.getFirst(); // Retrieves, but does not remove, the first element
        System.out.println("First element (getFirst): " + firstElement);
        String lastElement = deque.getLast(); // Retrieves, but does not remove, the last element
        System.out.println("Last element (getLast): " + lastElement);

        // 5. Size and Capacity
        int size = deque.size(); // Gets the number of elements in the deque
        boolean isEmpty = deque.isEmpty(); // Checks if the deque is empty
        System.out.println("Size of deque: " + size);
        System.out.println("Is the deque empty? " + isEmpty);

        // 6. Checking for Presence
        boolean containsCherry = deque.contains("Cherry"); // Checks if "Cherry" is in the deque
        System.out.println("Deque contains 'Cherry': " + containsCherry);

        // 7. Clearing the Deque
        deque.clear(); // Removes all elements from the deque
        System.out.println("Deque after clearing: " + deque);

        // 8. Adding Elements Again
        deque.addAll(Arrays.asList("Java", "Python", "C++", "JavaScript"));
        System.out.println("Deque before iteration: " + deque);

        // 9. Iteration
        System.out.println("Iterating using enhanced for loop:");
        for (String item : deque) {
            System.out.println(item);
        }

        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 10. Convert Deque to Array
        String[] array = deque.toArray(new String[0]); // Converts the deque to an array
        System.out.println("Array: " + Arrays.toString(array));

        // 11. Reverse the Deque
        Deque<String> reversedDeque = new LinkedList<>();
        Iterator<String> reverseIterator = deque.descendingIterator();
        while (reverseIterator.hasNext()) {
            reversedDeque.add(reverseIterator.next());
        }
        System.out.println("Reversed deque: " + reversedDeque);

        // 12. Rotate the Deque (Left Rotation)
        rotateLeft(deque);
        System.out.println("Deque after left rotation: " + deque);

        // 13. Rotate the Deque (Right Rotation)
        rotateRight(deque);
        System.out.println("Deque after right rotation: " + deque);

        // 14. Merge Two Deques
        Deque<String> deque2 = new LinkedList<>(Arrays.asList("Ruby", "Swift"));
        deque.addAll(deque2);
        System.out.println("Merged deque: " + deque);

        // 15. Sub-Dequeue
        Deque<String> subDeque = new LinkedList<>(deque);
        while (subDeque.size() > 2) {
            subDeque.removeLast(); // Remove elements until size is 2
        }
        System.out.println("Sub-deque with 2 elements: " + subDeque);
    }

    private static void rotateLeft(Deque<String> deque) {
        if (deque.isEmpty()) return;
        String firstElement = deque.removeFirst();
        deque.addLast(firstElement);
    }

    private static void rotateRight(Deque<String> deque) {
        if (deque.isEmpty()) return;
        String lastElement = deque.removeLast();
        deque.addFirst(lastElement);
    }

    public static void main(String[] args) {
        demonstrateDequeOperations();
    }
}

