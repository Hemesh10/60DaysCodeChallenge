package problems;

// Search a 2D Matrix
/*
   You are given an m x n integer matrix 'matrix' with the following two properties:
   1. Each row is sorted in non-decreasing order.
   2. The first integer of each row is greater than the last integer of the previous row.

   Given an integer target, return true if target is in matrix or false otherwise.

   You must write a solution in O(log(m * n)) time complexity.
 */

public class Day13Problem_SearchA2DMatrix {

    static  boolean searchMatrix(int[][] matrix, int target) {
        int l1 = 0, h1 = matrix.length - 1;

        while (l1 <= h1) {
            int m1 = (l1 + h1) / 2;
            int low = 0, high = matrix[m1].length - 1;
            // checking whether the target lies in this row or not
            if (matrix[m1][low] <= target && matrix[m1][high] >= target) {
                int l2 = 0, h2 = matrix[m1].length - 1;
                while (l2 <= h2) {
                    int m2 = (l2 + h2) / 2;
                    if (matrix[m1][m2] == target) {
                        System.out.println("Target " + target + " is at index " + m2 + " of row " + m1);
                        return true;
                    } else if (matrix[m1][m2] > target) {
                        h2 = m2 - 1;
                    } else {
                        l2 = m2 + 1;
                    }
                }
                return false;
            } else if (matrix[m1][low] > target) {
                // since each row is sorted, and it is given that the first integer of eah row
                // is grater than the last integer of previous row, we can check through the above
                // condition that whether out target is going to be there at the previous row corresponding
                // to the current row or on the next row with respect to the current row
                h1 = m1 - 1;
            } else  {
                l1 = m1 + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Input Case 01:
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };
        int target = 60;

        // Input Case 02:
        // int[][] matrix = {
        //          {1, 3, 5, 7},
        //          {10, 11, 16, 20},
        //          {23, 30, 34, 60},
        //  };
        // int target = 8;


        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }
}
