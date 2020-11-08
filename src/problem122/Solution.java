package problem122;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        /*  每个状态的含义
                dp[i][0]代表在第i天结束之后，持有股票的最大收益
                dp[i][1]代表在第i天结束之后，不持有股票的最大收益
        */
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        }
        return dp[n - 1][1];
    }
}