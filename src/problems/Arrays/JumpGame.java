package problems.Arrays;

public class JumpGame {
    static boolean canJump(int[] nums) {
        int n = nums.length;

        if (n == 1) return true;
        if (nums[0] == 0) return false;

        int target = n - 1;
        System.out.println(target);

        if (nums[0] >= target) return true;

        for (int i = n - 2 ; i >= 0 ; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }

        return target == 0;
    }
    public static void main(String[] args) {
        int[] nums = {3, 0, 8, 2, 0, 0, 1};

        boolean res = canJump(nums);
        System.out.println(res);
    }
}
