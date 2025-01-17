/*
Difficulty: Easy
Pattern: Linear search
Problem: 1672. Richest Customer Wealth
*/

public class RichCustomer {

    // Time complexity: O(N)
    // Space complexity: O(1)
    static int wealth(int[] amounts) {
        int sum = 0;
        for (int amount : amounts) sum += amount;
        return sum;
    }

    // Time complexity: O(N*M)
    // Space complexity: O(1)
    static int findRichest(int[][] accounts) {
        int maxAmount = 0;
        for (int[] account : accounts) maxAmount = Math.max(
            maxAmount,
            wealth(account)
        );
        return maxAmount;
    }
}
