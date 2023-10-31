package problems;

public class Day1Problem_KokoEatsBananas {
    static int getMaxEatingSpeed(int[] piles) {
        int max = 1;
        for (int i = 0 ; i < piles.length ; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

    static int countTotalHours(int[] piles, int perH) {
        int totalHourPerPile = 0;
        for (int i = 0 ; i < piles.length ; i++) {
            totalHourPerPile += Math.ceil((double) piles[i] / (double) (perH));
        }
        return totalHourPerPile;
    }
    static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMaxEatingSpeed(piles);

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int totalHours = countTotalHours(piles, mid);
            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int res = minEatingSpeed(piles, h);
        System.out.println(res);
    }
}
