package problems;

// Aggressive Cows

// You are given an array 'arr' consisting of 'n' integers, where, arr[i] denoted the position of a stall.
// You are also given an integer 'k' which denoted the  number of aggressive cows. You are given the task
// of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible

import java.util.Arrays;
public class Day6Problem_AggressiveCows {
    static boolean isAllocationPossible(int[] stalls, int k, int n) {
        int cowsCount = 1, lastPosition = stalls[0];
        // we place the first cows at the first stall beforehand (greedy) and then place other remaining one's
        // and since the first cow has already been placed at the first stall, the cowsCount is 1 initially
        for (int i = 1 ; i < stalls.length ; i++) {
            if (stalls[i] - lastPosition >= k) { // here, k is the dist. for which we are doing the allocations
                // if the dist. between the cow at the ith stall and the cow at the previous stall is at least k
                // it means we can place a cow at that ith stall. Hence, we increment the cowsCount and update the
                // lastPostion which denotes the latest position of a placed cow
                cowsCount++;
                lastPosition = stalls[i];
            }

            // we are checking here that have we placed 'n' number of cows with the given distance 'k'
            if (cowsCount >= n) return true;
        }
        return false;
    }
    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        // we sorted the given array in order to find the maximum and the minimum
        // possible distance between any of the two cows
        int n = stalls.length;

        // The minimum possible distance is obviously going to 1 unit
        // The maximum possible distance between any two cows will be
        // the position of last stall minus the position of the first stall
        int low = 1, high = stalls[n - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isAllocationPossible(stalls, mid, k)) {
                // if this is true, it means that with distance (mid), we were able to allocate the 'k' cows. But,
                // we still need to look at the right portion of the array as we are told to find the maximum possible
                // distance and since the array is sorted, we will have greater values towards the right portion and
                low = mid + 1;
            } else {
                // else will only run if we were not able to allocate the 'k' cows with mid units of distance.
                // so we remove the right portion from our search space as we know the right portion will have even
                // higher values than this mid.
                high = mid - 1;
            }
        }

        return high;
    }
    public static void main(String[] args) {
        int[] arr = {18, 27, 44, 77, 69, 19, 35, 83, 9, 64};
        int cows = 4;
        int res = aggressiveCows(arr, cows);
        System.out.println(res);
    }
}
