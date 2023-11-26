package problems;

// Median in a Row Wise Sorted Matrix
/*
   Given a row wise sorted matrix 'mat' os size m * n, where 'm' and 'n' are the numbers of rows and columns of
   matrix respectively. Find the median of the matrix
   NOTE - 'm' and 'n' will always be odd
 */

public class Day16Problem_MedianInARowWiseSortedArray {
    static int upperBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe our answer
            if (arr[mid] > x) {
                high = mid - 1; // se we look for smaller index on the left search space
            } else {
                low = mid + 1; // or else we have to look at the right search space for higher values
            }
        }
        return low;
    }

    static int countSmallOrEqual(int[][]mat, int n, int m, int x) {
        int counter = 0;
        for (int i = 0 ; i < n ; i++) {
            counter += upperBound(mat[i], m, x);
        }
        return counter;
    }

    static int findMedian(int[][] mat, int n, int m) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (mat[i][j] > high) {
                    high = mat[i][j];
                }
                if (mat[i][j] < low) {
                    low = mat[i][j];
                }
            }
        }

        int requiredIndex = (n * m) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallOrEqual = countSmallOrEqual(mat, n, m, mid);
            if (smallOrEqual <= requiredIndex) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 5, 7, 9, 11},
                {2, 3, 4, 8, 9},
                {4, 11, 14, 19, 20},
                {6, 10, 22, 99, 100},
                {7, 5, 17, 24, 28}
        };

        int res = findMedian(mat, mat.length, mat[0].length);
        System.out.println(res);
    }
}
