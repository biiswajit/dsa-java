/*
Difficulty: Easy
Pattern: Linear search
*/

public class LinearSearch {

    // Time complexity: Best O(1), Worst O(N)
    // Space complexity: Best O(1), Worst O(1)
    static int linearSearch(int[] arr, int key) {
        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
}
