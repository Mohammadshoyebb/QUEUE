// 950. Reveal Cards In Increasing Order
// Solved
// Medium
// Topics
// Companies
// You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
// 
// You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
// 
// You will do the following steps repeatedly until all cards are revealed:
// 
// Take the top card of the deck, reveal it, and take it out of the deck.
// If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
// If there are still unrevealed cards, go back to step 1. Otherwise, stop.
// Return an ordering of the deck that would reveal the cards in increasing order.
// 
// Note that the first entry in the answer is considered to be the top of the deck.
// 
// Example 1:
// 
// Input: deck = [17,13,11,2,3,5,7]
// Output: [2,13,3,11,5,17,7]
// Explanation: 
// We get the deck in the order [17,13,11,2,3,5,7] (this order does not matter), and reorder it.
// After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
// We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
// We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
// We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
// We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
// We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
// We reveal 13, and move 17 to the bottom.  The deck is now [17].
// We reveal 17.
// Since all the cards revealed are in increasing order, the answer is correct.
// Example 2:
// 
// Input: deck = [1,1000]
// Output: [1,1000]
// 
// Constraints:
// 
// 1 <= deck.length <= 1000
// 1 <= deck[i] <= 106
// All the values of deck are unique.

import java.util.*;

public class RevealCardsInIncreasingOrder {
    
    // Approach 1
    public int[] deckRevealedIncreasing1(int[] deck) {
        int n = deck.length;
        int result[] = new int[n];
        Arrays.sort(deck);

        int i = 0;
        int j = 0;
        boolean skip = false;

        while (i < n) {
            if (result[j] == 0) {
                if (!skip) {
                    result[j] = deck[i];
                    i++;
                }
                skip = !skip;  // flipping the value of skip
            }
            j = (j + 1) % n;
        } 
        return result; 
    }

    // Approach 2
    public int[] deckRevealedIncreasing2(int[] deck) {
        int n = deck.length;
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.sort(deck);
        int result[] = new int[n];

        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        for (int i = 0; i < n; i++) {
            result[q.poll()] = deck[i];
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        return result;
    }

    // Approach 3
    public int[] deckRevealedIncreasing3(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck); // Sort the deck in increasing order

        Deque<Integer> deque = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = deque.removeFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder sol = new RevealCardsInIncreasingOrder();
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        
        // Test Approach 1
        int[] result1 = sol.deckRevealedIncreasing1(deck);
        System.out.println("Approach 1: " + Arrays.toString(result1));
        
        // Test Approach 2
        int[] result2 = sol.deckRevealedIncreasing2(deck);
        System.out.println("Approach 2: " + Arrays.toString(result2));
        
        // Test Approach 3
        int[] result3 = sol.deckRevealedIncreasing3(deck);
        System.out.println("Approach 3: " + Arrays.toString(result3));
    }
}

