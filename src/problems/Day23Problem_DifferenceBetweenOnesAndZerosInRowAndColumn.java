package problems;

import java.util.Arrays;

public class Day23Problem_DifferenceBetweenOnesAndZerosInRowAndColumn {
    static int[] countRowZerosAndOnes(int[][] mat, int m, int i) {
        int countOfOnes = 0;
        for (int j = 0 ; j < m ; j++) {
            countOfOnes += mat[i][j];
        }

        return new int[]{m - countOfOnes, countOfOnes};
    }
    static int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // counting the number of one's in each column
        int[] colOnes = new int[m];
        for (int i = 0 ; i < m ; i++) {
            int onesCount = 0;
            for (int j = 0 ; j < n ; j++) {
                onesCount += grid[j][i];
            }
            colOnes[i] = onesCount;
        }

        System.out.println(Arrays.toString(colOnes));

        for (int i = 0 ; i < n ; i++) {
            int[] rowZerosAndOnes = countRowZerosAndOnes(grid, m, i);
            for (int j = 0 ; j < m ; j++) {
                grid[i][j] = rowZerosAndOnes[1] + colOnes[j] - rowZerosAndOnes[0] - (n - colOnes[j]);
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
        };

        int[][] res = onesMinusZeros(grid);
        System.out.println(Arrays.deepToString(res));
    }
}
