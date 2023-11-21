package problems;

import java.util.Arrays;

public class Day15Problem_PeakElement2 {
    static int getMaxRow(int[][] mat, int n, int col) {
        int maxValue = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0 ; i < n ; i++) {
            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    static int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid  = (low + high) / 2;
            int maxRowIndex = getMaxRow(mat, n, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;
            if (mat[maxRowIndex][mid] > left && right < mat[maxRowIndex][mid]) {
                return new int[]{maxRowIndex, mid};
            } else if (left > mat[maxRowIndex][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
//                {10, 20, 30, 50, 20},
//                {1, 3, 2, 500, 4},
//                {10, 50, 40, 30, 20},
//                {1, 500, 2, 3, 4},
                {10, 20, 40, 50, 60, 70},
                {1, 4, 2, 3, 500, 80},
        };
        int[] res = findPeakGrid(matrix);
        System.out.println(Arrays.toString(res));
    }
}
