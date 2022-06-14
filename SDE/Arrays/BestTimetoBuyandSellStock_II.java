public class BestTimetoBuyandSellStock_II {

    //Buy and sell on multiple days (any number of transactions) but at most you can hold only one share
    // [7,1,5,3,6,4]
    // 1-5 profit = 4
    // 3-6 profit = 3  , thus total profit = 7
    public int maxProfit(int[] prices) {

        int cheapest = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - cheapest > 0) {
                profit += prices[i] - cheapest;
                cheapest = prices[i];
            }
            if (cheapest > prices[i]) {
                cheapest = prices[i];
            }
        }
        return profit;

    }
}
