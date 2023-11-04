package problems;

// Capacity To Ship Packages Within D Days
// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with
// packages on the conveyor belt (in the order given by weights). We may not load more weight than
// the maximum weight capacity of the ship. Return the least weight capacity of the ship that will
// result in all the packages on the conveyor belt being shipped within days days.

public class Day4Problem_CapacityToShipPackagesWithinDDays {
    static int[] getLowestAndMaximumWeightCapacity(int[] arr) {
        int low = arr[0], max = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            max += arr[i];
            if (arr[i] > low) {
                low = arr[i];
            }
        }
        return new int[]{low, max};
    }

    static boolean isShipmentPossible(int[] weights, int totalDays, int k) {
        // here, k is our possible answer we will check that whether we will be able to ship
        // all the shipments within the given days using k capacity
        int sum = 0, day = 1;
        for (int i = 0 ; i < weights.length ; i++) {
            if (sum + weights[i] > k ) {
                // this condition will only become true when the weight of packages becomes greater than k
                // which means that on that given day, we cannot add any more packages. So we increment the
                // day and update the sum to that extra weight
                day++;
                sum = weights[i];
            } else {
                // else we just add up the weight to the ship until it is less that or equal to the capacity k
                sum += weights[i];
            }

            if (day > totalDays) {
                return false;
            }
        }
        return true;
    }
    static int shipWithinDays(int[] weights, int days) {
        // calculating the heaviest and the summation of all the wights of the given array as the
        // heaviest wight is the least possible capacity and the summation of all the weights will
        // be the highest possible capacity. So, out answer will lie between these two values
        int[] lowAndHigh =  getLowestAndMaximumWeightCapacity(weights);
        int low = lowAndHigh[0], high = lowAndHigh[1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(isShipmentPossible(weights, days, mid)) {
                high = mid - 1;
                // since we need to find the least weight capacity
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        // Input Case 1
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;

        // Input Case 2
        // int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int days = 5;

        // Input Case 3
        // int[] weights = {1, 2, 3, 1, 1};
        // int days = 4;

        int res = shipWithinDays(weights, days);
        System.out.println(res);
    }
}
