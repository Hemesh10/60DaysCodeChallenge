package problems;

public class Day17Problem_JumpGame {
    static boolean canJump(int[] nums) {
        int n = nums.length;

        if (n == 1) return true; // for obvious reason
        if (nums[0] == 0) return false; // as we cant jump at all

        int target = n - 1;

        // checking we can directly jump to the last index from the starting position
        // if yes, return true
        if (nums[0] >= target) return true;

        // We will start from the last second position and going to check that whether are we able
        // to reach to the last. If we can, we will update our target index to our current position.
        // Eventually, if we are able to make the 0th index as our target, we then know for sure that
        // we will be able to reach to the last index
        for (int i = n - 2 ; i >= 0 ; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }

        return target == 0; // if the target is at 0th index, it will return true of false otherwise
    }

    public static void main(String[] args) {
        // Input Case 01:
        int[] nums = {3, 0, 8, 2, 0, 0, 1};

        // Input Case 02:
        // int[] nums = {2, 3, 1, 1, 4};

        // Input Case 03:
        // int[] nums = {3, 2, 1, 0, 4};

        boolean res = canJump(nums);
        System.out.println(res);
    }
}
