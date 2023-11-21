package problems;

// Row With Maximum Ones

// Given a (m x n) binary matrix mat, find the 0-indexed position of the row that contains
// the maximum count of ones, and the number of ones in that row.
// In case there are multiple rows that have the maximum count of ones,
// the row with the smallest row number should be selected.
// Return an array containing the index of the row, and the number of ones in it.

public class Day12Problem_RowWithMax1s {
    static int countNumberOf1s(int[] row, int m) {
        // counting the number of 1s in a parting row using binary search
        // as the rows are sorted and only contains 0s and 1s.
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return m - low;
    }
    static int maximumOnesRow(int[][] matrix, int n, int m) {
        int maxCount = -1;
        int index = -1;

        for (int i = 0 ; i < n ; i++) {
            int countOf1s = countNumberOf1s(matrix[i], m);
            if (countOf1s > maxCount) { // since we need the smaller index in case of similar instances of 1s
                maxCount = countOf1s;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        // Input Case 01:
        int[][] arr = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        // Input Case 02:
        // int[][] arr = {
        //         {0, 0},
        //         {1, 1},
        //         {0, 0}
        // };

        // Input Case 03:
        // int[][] arr = {
        //         {0, 0, 0},
        //         {0, 1, 1},
        //         {1, 0, 0}
        // };

        int res = maximumOnesRow(arr, arr.length, arr[0].length);
        System.out.println(res);
    }
}
