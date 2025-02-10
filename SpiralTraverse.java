/*
Difficulty: Medium
Problem: Spiral traverse
Pattern: spiral traversal
 */

public class SpiralTraverse {
    // O(n*m) time | O(n*m) space
    static int[] spiralTraverse(int[][] arr) {
        // total number of elements in the input array
        int n = arr.length * arr[0].length;
        // array to store elements in spiral order
        int[] seq = new int[n];
        // initial boundary, reference of 4 corners of rectangle
        int rowStart = 0, rowEnd = arr.length-1;
        int colStart = 0, colEnd = arr[0].length-1;
        // index to store elements in output array
        int i = 0;
        // stop when no more un-visited elements left
        while (n>0) {
            // upper border
            for (int col=colStart; col<colEnd; col++) {
                seq[i++] = arr[rowStart][col];
                n--;
            }
            // right border
            for (int row=rowStart; row<rowEnd; row++) {
                seq[i++] = arr[row][colEnd];
                n--;
            }
            // lower border
            for (int col=colEnd; col>colStart; col--) {
                seq[i++] = arr[rowEnd][col];
                n--;
            }
            // left border
            for (int row=rowEnd; row>rowStart; row--) {
                seq[i++] = arr[row][colStart];
                n--;
            }

            // shrink the rectangle
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return seq;
    }
}
