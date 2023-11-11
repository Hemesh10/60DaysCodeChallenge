package problems;

// Split Array Largest Sum
/*
   Given an integer array nums and an integer k, split nums into k non-empty subarrays such that
   the largest sum of any subarray is minimized. Return the minimized largest sum of the split.
   A subarray is a contiguous part of the array.
*/

public class Day8Problem_SplitArrayLargestSum {
    static int[] getMaxAndSummation(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1 ;  i < nums.length ; i++) {
            sum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return new int[]{max, sum};
    }

    static boolean kNumberOfSplits(int[] nums, int totalSum, int k) {
        int arraysCount = 1, sum = 0;
        for (int num : nums) {
            if (sum + num <= totalSum) {
                sum += num;
            } else {
                arraysCount++;
                sum = num;
            }

            if (arraysCount > k) return false;
        }
        return true;
    }

    static int splitArray(int[] nums, int k) {
        int[] lowAndHigh = getMaxAndSummation(nums);
        int low = lowAndHigh[0], high = lowAndHigh[1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (kNumberOfSplits(nums, mid, k)) {
//                System.out.println("Possible answer - " + mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        // Input case 1 :
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        // Inout case 2 :
        // int[] nums = {1, 2, 3, 4, 5};
        // int k = 2;


        int res = splitArray(nums, k);
        System.out.println(res);
    }
}
