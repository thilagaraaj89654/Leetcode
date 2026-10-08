class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for (int price : prices) {
            int prevHold = hold;
            int prevSold = sold;
            hold = Math.max(hold, rest - price);
            sold = prevHold + price;
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}