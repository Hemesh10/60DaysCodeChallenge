package problems;

// Minimum Number of Days to Make m Bouquets
/*
   You are given an integer array bloomDay, an integer m and an integer k. You want to make m bouquets.
   To make a bouquet, you need to use k adjacent flowers from the garden. The garden consists of n flowers,
   the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
   Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
   If it is impossible to make m bouquets return -1.
*/


public class Day3Problem_MinimumNumberOfDaysToMakeMBouquets {
    static int getNumberOfBloomedFlowers(int[] arr, int numberOfDaysWaited, int k) {
        int totalFlowersBloomed = 0, counter = 0; // counter variable to check for adjacent flowers
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] <= numberOfDaysWaited) {
                counter++;
            } else { // else will only run if we don't find an adjacent flower. So, we add the previous adjacent flowers and will check later that are these adjacent flowers are making up the given numbers of bouquets (m) to make.
                totalFlowersBloomed += (counter / k);
                counter = 0; // and then we set to counter again to 0 and check for the remaining adjacent flowers
            }
        }
        totalFlowersBloomed += (counter / k); // we also need to add the previous adjacent flowers sum before return the total number of adjacent flowers
        return totalFlowersBloomed;
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m*k) return -1; //edge case

        // calc. the minimum and maximum days to wait for flowers to bloom (for bs range)
        int min = bloomDay[0], max = bloomDay[0];
        for (int i = 1 ; i < bloomDay.length ; i++) {
            if (bloomDay[i] > max) {
                max = bloomDay[i];
            }
            if (bloomDay[i] < min) {
                min = bloomDay[i];
            }
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int bloomedFlowers = getNumberOfBloomedFlowers(bloomDay, mid, k);
            if (bloomedFlowers >= m) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2, k = 3;
        int res = minDays(bloomDay, m, k);
        if (res != -1) {
            System.out.println("We would have to wait for " + res + " days in order to make " + m + " bouquets using " + k + " adjacent flowers for each bouquet.");
        } else {
            System.out.println("Is is impossible to make " + m + " bouquets with each bouquet containing " + k + " adjacent flowers for the given inputs.");
        }
    }
}
