/*
Difficulty: Easy
Problem: 1. Two Sum
Pattern: Two Sum
 */
import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {
    // O(N^2) time complexity
    // O(1) space complexity
    static int[] twoSumI(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            int firstNumber = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                int secondNumber = arr[j];
                int currentSum = firstNumber + secondNumber;
                if (currentSum == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    // O(N) time complexity
    // O(N) space complexity
    static int[] twoSumII(int[] arr, int target) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        for (int i=0; i<arr.length; i++) {
            int firstNumber = arr[i];
            int secondNumber = target - firstNumber;
            if (memo.containsKey(secondNumber)) return new int[]{i, memo.get(secondNumber)};
            memo.put(firstNumber, i);
        }
        return new int[]{-1, -1};
    }

    /*
    Previous two solutions were returning indices of first and second number, since we were returning indices we did not change the order
    But what if we have to return the number instead of indices, then we can change the order
     */
    // Algoexpert two number sum problem
    // O(N*logN) time complexity
    // O(1) space complexity
    static int[] twoNumberSum(int[] arr, int target) {
        // sort the array in place (assuming we do not care about the order of elements)
        Arrays.sort(arr);
        int small = 0, large = arr.length - 1;
        while (small < large) {
            int currentSum = arr[small] + arr[large];
            if (currentSum == target) return new int[] {small, large};
            else if (currentSum < target) small += 1;
            else large -= 1;
        }
        return new int[] {-1, -1};
    }
}
