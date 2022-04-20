public class BestTimetoBuyandSellStock_I {

    //[7,1,2,4,5,6,3]
    //profit: 5
    public int maxProfit(int[] prices) {
        int cheapest = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - cheapest > profit) {
                profit = prices[i] - cheapest;
            }

            if (cheapest > prices[i]) {
                cheapest = prices[i];
            }
        }
        return profit;
    }
}
