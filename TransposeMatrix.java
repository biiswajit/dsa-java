/*
Difficulty: Easy
Problem: Transpose matrix
Pattern: Linear search and swapping
 */

public class TransposeMatrix {
    // O(n*n) time | O(1) space
    static int[][] transposeMatrix (int[][] matrix) {
        for (int row=0; row<matrix.length; row++) {
            // iterate over the upper diagonal
            for (int col=row+1; col<matrix.length; col++)
                transpose(matrix, row, col);
        }
        return matrix;
    }

    static void transpose(int[][] matrix, int row, int col) {
        // transpose index of [a,b] is [b,a]
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }
}
