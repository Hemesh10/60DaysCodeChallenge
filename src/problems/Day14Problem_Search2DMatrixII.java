package problems;

public class Day14Problem_Search2DMatrixII {

    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int topShift = 0, leftShift = matrix[0].length - 1;
        while (topShift < n  && leftShift >= 0) {
            int current = matrix[topShift][leftShift];
            System.out.println(current);
            if (current == target) {
                System.out.println("Target " + target + " is index " + leftShift + " of row " + topShift);
                return true;
            }
            else if (current > target) {
                leftShift--;
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
