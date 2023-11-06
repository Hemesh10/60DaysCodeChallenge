package problems;

public class Day5Problem_KthMissingPositiveNumber {
    static int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) return k;

//        Brute force:
//        for (int i = 0 ; i < arr.length ; i++) {
//            if (arr[i] <= k) {
//                k++;
//            } else {
//                break;
//            }
//        }
//        return k;

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid  = low + (high - low) / 2;
            if (arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // arr[high] + (k + (arr[high] - (high + 1))) --> arr[high] + k - (arr[high] - high - 1) -->
        // arr[high] + k - arr[high] + high + 1 --> k + high + 1;
        return k + high + 1;
    }
    public static void main(String[] args) {
        // Input case 1:
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        // Input case 2:
        // int[] arr = {4, 7, 11};
        // int k = 2;

        // Input case 3:
        // int[] arr = {4, 7, 11};
        // int k = 2;
        int res = findKthPositive(arr, k);
        System.out.println(res);
    }
}
