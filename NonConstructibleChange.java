/*
Difficulty: Easy
Problem: Non constructible change
Pattern: Linear search and sorting

Idea!
if, current coin = c
if, max generated change so far = v
if, c > v + 1, then v+1 is the minimum change that you can not create
 */

import java.util.Arrays;

public class NonConstructibleChange {
    // O(n log n) time | O(1) space
    static int nonConstructibleChangeI(int[] coins) {
        Arrays.sort(coins);
        int maxChangeCreated = 0;
        for (int coin: coins) {
            if (coin > maxChangeCreated + 1) return maxChangeCreated + 1;
            maxChangeCreated = maxChangeCreated + coin;
        }
        return maxChangeCreated + 1;
    }
}
