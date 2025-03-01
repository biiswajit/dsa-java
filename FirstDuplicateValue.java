/*
Difficulty: Medium
Problem: First duplicate value
Pattern: Cyclic sort
 */
import java.util.HashMap;

public class FirstDuplicateValue {
    // O(n) time | O(n) space
    static int firstDuplicateValueI(int[] arr) {
        // contains all values that i am currently seeing
        HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
        // iterate over array and if element previously visited then found the first duplicate
        for (int element : arr) {
            if (seen.containsKey(element)) return element;
            seen.put(element, true);
        }
        // no duplicate present
        return -1;
    }

    // O(n) time | O(1) space
    static int firstDuplicateValueII(int[] arr) {
        // iterate over the array and get the current present element
        for (int element : arr) {
            // cyclic sort logic : find the index where the current element supposed to be
            int actualIdx = Math.abs(element) - 1;
            // if at actual index already marked then it means current element is duplicate in the array
            if (arr[actualIdx] < 0) return Math.abs(element);
            // otherwise, mark the current element as present
            arr[actualIdx] *= -1;
        }
        // no duplicate present
        return -1;
    }
}
