//package problems;
//
//public class Day9Problem_MinimizeMaxDistanceToGasStation {
//    static int getMaxDistance(int[] arr) {
//        int max = arr[1] - arr[0];
//        for (int i = 2 ; i < arr.length ; i++) {
//            if (arr[i] - arr[i - 1] > max) {
//                max = arr[i] - arr[i - 1];
//            }
//        }
//        return max;
//    }
//    static int MinimiseMaxDistance(int[] arr, int k) {
//        for (int i = 1 ; i <= k ; i++) {
//            int[] sections = new int[arr.length - 1];
//
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {1, 13, 17, 23, 36};
//        int k = 5;
//
//        int res = MinimiseMaxDistance(arr, k);
//    }
//}
