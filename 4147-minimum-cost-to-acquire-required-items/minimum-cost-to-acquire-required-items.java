class Solution {
    public long minimumCost(long cost1, long cost2, long costBoth, long need1, long need2) {
        long common = Math.min(need1, need2);
        long rem1 = need1 - common;
        long rem2 = need2 - common;

        // Cost for satisfying the overlapping requirements
        long totalCost = common * Math.min(costBoth, cost1 + cost2);

        // Cost for the remaining requirement (if any)
        if (rem1 > 0) {
            totalCost += rem1 * Math.min(costBoth, cost1);
        } else if (rem2 > 0) {
            totalCost += rem2 * Math.min(costBoth, cost2);
        }

        return totalCost;
    }
}