class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        
        long common = Math.min(need1, need2);
        long totalCost = common * Math.min(cb, c1 + c2);
        
        if (need1 > need2) {
            long remaining = need1 - need2;
            totalCost += remaining * Math.min(c1, cb);
        } else if (need2 > need1) {
            long remaining = need2 - need1;
            totalCost += remaining * Math.min(c2, cb);
        }
        
        return totalCost;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna