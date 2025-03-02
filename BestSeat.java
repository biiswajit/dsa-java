/*
Difficulty: Medium
Problem: Best seat
Pattern: linear search
 */

public class BestSeat {
    // O(n) time | O(1) space
    static int bestSeat(int[] row) {
        // initials
        int leftMostSeat = 0, rightMostSeat = 0;
        int bestSeat = -1, maxEmptySeatsFound = 0;

        for (int col = 0; col < row.length; col ++) {
            // very iteration right most seat updates
            rightMostSeat = col;
            // seat is occupied
            if (row[col] > 0) {
                // get the number of empty seats
                int numberOfEmptySeats = rightMostSeat - leftMostSeat - 1;
                // current number of empty seats is more that what found previously
                if (numberOfEmptySeats > maxEmptySeatsFound) {
                    // update the answer
                    maxEmptySeatsFound = numberOfEmptySeats;
                    bestSeat = (rightMostSeat + leftMostSeat) / 2;
                }
                // update left most seat everytime you see a occupied seat
                leftMostSeat = col;
            }
        }

        return bestSeat;
    }
}