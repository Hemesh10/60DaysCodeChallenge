package problems;

// Find the Smallest Divisor Given a Threshold

/* Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
   divide all the array by it, and sum the division's result. Find the smallest divisor such that the result
   mentioned above is less than or equal to threshold. Each result of the division is rounded to the nearest
   integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
   If the result can not be possible, return -1. */

public class Day2Problem_SmallestDivisorGivenAThreshold {
    static int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    static int getDivisorSum(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / (double) k);
        }
        System.out.println(k + " : " + sum);
        return sum;
    }
    static int smallestDivisor(int[] nums, int threshold) {
        if (nums.length > threshold) return -1; // Edge case. The result will always be greater than the threshold

        // finding the maximum number in the array as any array[i] / maxNum will always be equal to 1 (as we need the ceil value). So our answer will always lie between 1 ans maxNum
        int low = 1, high = getMax(nums);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getDivisorSum(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        // test case 1
        int[] nums = {44,22,33,11,1};
        int threshold = 5;

        // test case 2
        // int[] nums = {1, 2, 5, 9};
        // int threshold = 6;

        int res = smallestDivisor(nums, threshold);
        System.out.println(res);
    }
}
