package problems;

public class Day25Problem_BestTimeToBuyOrSellStock {
    static int maxProfit(int[] prices) {
        int n = prices.length;

        int smallestPrice = Integer.MAX_VALUE;
        int profit, maxProfit = 0;

        for (int i = 0 ; i < n ; i++) {
            int currentPrice = prices[i];

            if (currentPrice < smallestPrice) {
                smallestPrice = currentPrice;
            }

            if (currentPrice > smallestPrice) {
                profit = currentPrice - smallestPrice;
                maxProfit = Math.max(profit, maxProfit);
            }

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};

        int res = maxProfit(prices);
        System.out.println(res);
    }
}
