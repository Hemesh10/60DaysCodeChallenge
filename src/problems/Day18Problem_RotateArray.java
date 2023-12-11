package problems;

import java.util.Arrays;

public class Day18Problem_RotateArray {
    static void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // if in case k > n

        // reversing the whole array
        reverse(nums, 0, n - 1);

        // reversing the first k element
        reverse(nums, 0, k - 1);

        // reversing the remaining elements
        reverse(nums, k, n-1);

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

//        int[] nums = {-1, -100, 3, 99};
//        int k = 2;

        rotate(nums, k);
    }
}
