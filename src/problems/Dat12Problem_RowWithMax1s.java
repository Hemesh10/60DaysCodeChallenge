package problems;

public class Day12Problem_RowWithMax1s {
    static int countNumberOf1s(int[] row, int m) {
//        int counter = 0;
//        for (int i = 0 ; i < m ; i++) {
//            counter += row[i];
//        }
//        return counter;
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
            if (countOf1s > maxCount) {
                maxCount = countOf1s;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        int res = maximumOnesRow(arr, arr.length, arr[0].length);
        System.out.println(res);
    }
}
