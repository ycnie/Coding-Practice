class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int curLow = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            curLow = prices[i] < curLow? prices[i] : curLow;
            res = Math.max(res, prices[i] - curLow);
        }
        return res;
    }
}

// Time: O(n)
// Space: O(1)