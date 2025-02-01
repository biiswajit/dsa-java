import java.util.Arrays;

/*
Difficulty: Easy
Problem: Sorted squared array
Pattern: Linear search with merge operation, two pointer
 */
public class SortedSquaredArray {
    // O(n log n) time | O(n) space
    static int[] sortedSquaredArrayI(int[] array) {
        // create a new array
        int[] squaredArray = new int[array.length];
        // perform square of each element from original array
        for (int i=0; i<array.length; i++) {
            squaredArray[i] = array[i] * array[i];
        }
        // sort the resulting squared array
        Arrays.sort(squaredArray);
        return squaredArray;
    }


    // O(n) time | O(n) space
    // linear search with merge operation
    static int[] sortedSquaredArrayII(int[] arr) {
        // create a new array
        int[] squaredArr = new int[arr.length];
        // find the point to divide the array in two parts
        int pivotIdx = 0;
        while (pivotIdx < arr.length && arr[pivotIdx] < 0) pivotIdx += 1;
        // perform merge operation
        int negIdx = pivotIdx - 1, posIdx = pivotIdx, idx = 0;
        while (negIdx >= 0 && posIdx < arr.length) {
            int a = arr[negIdx] * arr[negIdx];
            int b = arr[posIdx] * arr[posIdx];
            if (a < b) {
                squaredArr[idx++] = a;
                negIdx--;
            }
            else {
                squaredArr[idx++] = b;
                posIdx++;
            }
        }
        while (negIdx >= 0) {
            squaredArr[idx++] = arr[negIdx] * arr[negIdx];
            negIdx--;
        }
        while (posIdx < arr.length) {
            squaredArr[idx++] = arr[posIdx] * arr[posIdx];
            posIdx++;
        }
        return squaredArr;
    }


    // O(n) time | O(n) space
    // try populating squared array from right hand side
    // two pointer, little optimized
    static int[] sortedSquaredArrayIII(int[] arr) {
        int[] squaredArr = new int[arr.length];
        int idx = arr.length-1, highIdx = arr.length-1, lowIdx = 0;
        while (lowIdx <= highIdx) {
            if (Math.abs(arr[lowIdx]) > Math.abs(arr[highIdx])) {
                squaredArr[idx--] = arr[lowIdx] * arr[lowIdx];
                lowIdx++;
            }
            else {
                squaredArr[idx--] = arr[highIdx] * arr[highIdx];
                highIdx--;
            }
        }
        return squaredArr;
    }
}
