class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1_000_000_007L;
        int[] bitCount = new int[31];

        // Step 1: Count set bits at each position
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCount[bit]++;
                }
            }
        }

        long totalSum = 0;

        // Step 2: Form the top k largest possible numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            totalSum = (totalSum + (currentNum * currentNum) % mod) % mod;
        }

        return (int) totalSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna