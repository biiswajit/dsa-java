/*
Difficulty: Easy
Pattern: Binary Search
*/

public class BinarySearch {

    // Assuming array is already sorted in ascending order
    // Time complexity: O(logN)
    // Space complexity: O(1)
    static int binarySearchI(int[] arr, int key) {
        int startIdx = 0, endIdx = arr.length - 1;
        while (startIdx <= endIdx) {
            int midIdx = (endIdx - startIdx) / 2 + startIdx;
            if (arr[midIdx] == key) return midIdx;
            else if (arr[midIdx] > key) endIdx = midIdx - 1;
            else startIdx = midIdx + 1;
        }
        return -1;
    }

    // Order-agnostic binary search
    // Time complexity: O(logN)
    // Space complexity: O(1)
    static int binarySearchII(int[] arr, int key) {
        boolean ascendingOrder = arr[0] < arr[arr.length - 1];

        int startIdx = 0, endIdx = arr.length - 1;
        while (startIdx <= endIdx) {
            int midIdx = (endIdx - startIdx) / 2 + startIdx;
            if (arr[midIdx] == key) return midIdx;
            if (ascendingOrder) {
                if (arr[midIdx] > key) endIdx = midIdx - 1;
                else startIdx = midIdx + 1;
            } else {
                if (arr[midIdx] > key) startIdx = midIdx + 1;
                else endIdx = midIdx - 1;
            }
        }
        return -1;
    }
}
