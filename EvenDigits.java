/*
Difficulty: Easy
Pattern: Linear Search
*/

public class EvenDigits {

    // approach one
    // Time complexity: O(N) where N, is the number of digits
    // Space complexity: O(N), string size is linear with digits in given number
    static int getNumberOfDigitsI(int num) {
        if (num == 0) return 0;
        if (num < 0) num *= -1;

        String numString = Integer.toString(num);
        return numString.length();
    }

    // appraoch two
    // Time complexity: O(N), where N is the number of digits
    // Space complexity: O(1)
    static int getNumberOfDigitsII(int num) {
        if (num == 0) return 0;
        if (num < 0) num *= -1;

        int digitCount = 0;
        while (num > 0) {
            num /= 10;
            digitCount += 1;
        }
        return digitCount;
    }

    // approach three
    // Time complexity: O(1)
    // Space complexity: O(1)
    static int getNumberOfDigitsIII(int num) {
        if (num == 0) return 0;
        if (num < 0) num *= -1;

        return (int) (Math.log10(num)) + 1;
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    static int countOfEvenDigitNumbers(int[] arr) {
        if (arr.length <= 0) return 0;

        int numberCount = 0;
        for (int num : arr) {
            int numberOfDigits = getNumberOfDigitsIII(num);
            if (numberOfDigits % 2 == 0) numberCount += 1;
        }
        return numberCount;
    }
}
