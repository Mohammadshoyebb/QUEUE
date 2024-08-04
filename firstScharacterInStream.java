/*
 * Question: Find the First Non-Repeating Character in a Stream
 *
 * Given a string S, find the first non-repeating character for every character in the stream. 
 * If there is no such character, return -1 for that position.
 *
 * Write a function `printNonRepeating(String S)` that takes a string S as input and prints the 
 * first non-repeating character in the stream for each character in S.
 *
 * Example 1:
 * Input: S = "geeksforgeeks"
 * Output: g e e k f f f f f o o o r
 *
 * Explanation: 
 * - After reading 'g', the first non-repeating character is 'g'.
 * - After reading 'e', the first non-repeating character is 'g'.
 * - After reading 'e', the first non-repeating character is 'g'.
 * - After reading 'k', the first non-repeating character is 'g'.
 * - After reading 's', the first non-repeating character is 'g'.
 * - After reading 'f', the first non-repeating character is 'f'.
 * - After reading 'o', the first non-repeating character is 'f'.
 * - After reading 'r', the first non-repeating character is 'f'.
 * - After reading 'g', the first non-repeating character is 'f'.
 * - After reading 'e', the first non-repeating character is 'f'.
 * - After reading 'e', the first non-repeating character is 'f'.
 * - After reading 'k', the first non-repeating character is 'f'.
 * - After reading 's', the first non-repeating character is 'f'.
 *
 * Example 2:
 * Input: S = "aabc"
 * Output: a a b b c c -1 -1
 *
 * Explanation:
 * - After reading 'a', the first non-repeating character is 'a'.
 * - After reading 'a', the first non-repeating character is 'a'.
 * - After reading 'b', the first non-repeating character is 'a'.
 * - After reading 'c', the first non-repeating character is 'b'.
 * - After reading 'a', the first non-repeating character is 'b'.
 * - After reading 'b', the first non-repeating character is 'c'.
 * - After reading 'c', the first non-repeating character is '-1'.
 * - After reading 'c', the first non-repeating character is '-1'.
 */

 import java.util.*;

 public class firstScharacterInStream {
     public static void printNonRepeating(String str) {
         int freq[] = new int[26]; // Frequency array for characters 'a'-'z'
         Queue<Character> q = new LinkedList<>(); // Queue to store characters in the order they appear
 
         for (int i = 0; i < str.length(); i++) {
             char ch = str.charAt(i); // Get the current character
             q.add(ch); // Add the character to the queue
             freq[ch - 'a']++; // Increment the frequency of the character
 
             // Remove characters from the front of the queue if they have appeared more than once
             while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                 q.remove();
             }
 
             // Print the first non-repeating character or -1 if there are none
             if (q.isEmpty()) {
                 System.out.print(-1 + " ");
             } else {
                 System.out.print(q.peek() + " ");
             }
         }
         System.out.println();
     }
 
     public static void main(String[] args) {
         // Test cases
         printNonRepeating("geeksforgeeks"); // Output: g e e k f f f f f o o o r
         printNonRepeating("aabc"); // Output: a a b b c c -1 -1
         printNonRepeating("abcdabc"); // Output: a a b b c c d d
     }
 }
 
