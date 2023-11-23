package problems;

// Search a 2D Matrix II
/*
   Write an efficient algorithm that searches for a value target in an m x n integer matrix 'matrix'.
   This matrix has the following properties:
   1. Integers in each row are sorted in ascending from left to right.
   2. Integers in each column are sorted in ascending from top to bottom.
 */

public class Day14Problem_Search2DMatrixII {

    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int topShift = 0, rightShift = matrix[0].length - 1;

        while (topShift < n  && rightShift >= 0) {
            int current = matrix[topShift][rightShift];
            if (current == target) {
                System.out.println("Target " + target + " is index " + rightShift + " of row " + topShift);
                return true;
            }
            else if (current > target) {
                rightShift--;
            } else {
                topShift++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        // Input Case 01 :
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int target = 13;

        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }
}
