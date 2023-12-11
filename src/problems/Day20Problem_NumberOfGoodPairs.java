package problems;

public class Day20Problem_NumberOfGoodPairs {
    static int numIdenticalPairs(int[] nums) {
        int counter = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i+1 ; j < nums.length ; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        // Input Case 01:
        int[] nums = {1, 2, 3, 1, 1, 3};

        // Input Case 02:
        // int[] nums = {1, 1, 1, 1};

        // Input Case 01:
        // int[] nums = {1, 2, 3};

        int res = numIdenticalPairs(nums);
        System.out.println(res);
    }
}
