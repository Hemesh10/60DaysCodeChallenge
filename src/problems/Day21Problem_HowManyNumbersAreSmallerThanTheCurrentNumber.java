package problems;

import java.util.Arrays;

public class Day21Problem_HowManyNumbersAreSmallerThanTheCurrentNumber {
    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] frequency = new int[101]; // since 0 <= nums[i] <= 100
        for (int i = 0 ; i < nums.length ; i++) {
            frequency[nums[i]]++;
        }

        int currentAggregate = 0;
        int previousAggregate = 0;

        // given that --> 0 <= n <= 100
        for (int i = 0; i < frequency.length ; i++) {
            currentAggregate += frequency[i];
            frequency[i] = previousAggregate; // there is no number less than 0
            previousAggregate = currentAggregate;
        }

        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            res[i] =  frequency[nums[i]];
        }

        return res;
    }

    public static void main(String[] args) {
        // Inout Case 01:
        int[] nums = {8, 1, 2, 2, 3};

        // Input Case 02:
        // int[] nums = {6, 5, 4, 8};

        // Input Case 03:
        // int[] nums = {7, 7, 7, 7};

        int[] res = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(res));
    }
}
