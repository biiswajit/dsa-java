/*
Difficulty: Medium
Problem: Monotonic array
Pattern: Linear search and pair-wise comparison (like in bubble sort)
 */

public class MonotonicArray{
    // O(n) time | O(1) space
    static boolean monotonicArrayI (int[] arr) {
        enum direction {UP, DOWN};
        // figure out the direction to check for monotonicity
        if (arr[0] < arr[arr.length-1]) return monotonicity(arr, direction.UP.ordinal());
        else return monotonicity(arr, direction.DOWN.ordinal());
    }

    // helper function to do pair wise check for monotonicity
    static boolean monotonicity(int[] arr, int direction) {
        if (arr.length == 0) return false;
        int curr = 0, next = 1;
        while (next < arr.length) {
            boolean condition = (direction == 0) ? arr[curr] <= arr[next] : arr[curr] >= arr[next];
            if (!condition) return false;
            curr = next;
            next++;
        }
        return true;
    }
}
