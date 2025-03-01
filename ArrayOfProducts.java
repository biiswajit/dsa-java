/*
Difficulty: Medium
Problem: Array of products
Pattern: Linear search and two iterations
 */

import java.util.Arrays;

public class ArrayOfProducts {
    // O(n) time | O(n) space
    static int[] arrayOfProducts(int[] arr) {
        // for each number find the product of all left elements
        int[] leftProducts = new int[arr.length];
        leftProducts[0] = 1; // tbe base case
        for (int i = 1; i < arr.length; i++)
            leftProducts[i] = leftProducts[i - 1] * arr[i - 1];

        // for each number find the product of all right elements
        int[] rightProducts = new int[arr.length];
        rightProducts[arr.length - 1] = 1; // the base case
        for (int i = arr.length - 2; i >= 0; i--)
            rightProducts[i] = rightProducts[i + 1] * arr[i + 1];

        // multiply left product and right product
        int[] finalProducts = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            finalProducts[i] = leftProducts[i] * rightProducts[i];

        return finalProducts;
    }
}
