/*
Difficulty: Medium
Problem: Move element to end
Pattern: Linear search with two pointers (similar in quick sort to place pivot in correct place)
 */

public class MoveElementToEnd {
    // O(n) time | O(1) space
    static void moveElementToEndI(int[] arr, int e) {
        // initial position of two pointers
        int otherPtr = 0, instancePtr = arr.length-1;
        // two pointers are in a valid range
        while (otherPtr < instancePtr) {
            // keep updating the pointer until they violate the rule
            while (otherPtr < arr.length && arr[otherPtr] != e) otherPtr++;
            while (instancePtr >= 0 && arr[instancePtr] == e) instancePtr--;
            // if two pointers are in a valid range, swap values to satisfy the rule
            if (otherPtr < instancePtr) {
                int temp = arr[otherPtr];
                arr[otherPtr] = arr[instancePtr];
                arr[instancePtr] = temp;
            }
        }
    }
}
