class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = Math.max(0, j - 3); i < j; i++) {
                long cost = dp[i] + costs[j - 1] + (long) (j - i) * (j - i);
                dp[j] = Math.min(dp[j], cost);
            }
        }

        return (int) dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna