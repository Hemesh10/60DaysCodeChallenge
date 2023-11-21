package problems;

public class Day13Problem_SearchA2DMatrix {

    static  boolean searchMatrix(int[][] matrix, int target) {
        int l1 = 0, h1 = matrix.length - 1;

        while (l1 <= h1) {
            int m1 = (l1 + h1) / 2;
            int low = 0, high = matrix[m1].length - 1;
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


        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }
}
