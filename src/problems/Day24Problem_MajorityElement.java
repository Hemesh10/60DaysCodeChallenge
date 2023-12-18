package problems;

public class Day24Problem_MajorityElement {
    static int majorityElement(int[] nums) {
        int n = nums.length;

        int res = nums[0];
        int count = 1;

        for (int i = 1 ; i < n ; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int res = majorityElement(nums);
        System.out.println(res);
    }
}
