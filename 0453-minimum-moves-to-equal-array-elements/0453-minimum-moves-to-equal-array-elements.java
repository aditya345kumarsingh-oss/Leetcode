
class Solution {
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        long sum = 0;

        // Find minimum element and calculate sum
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        // Calculate minimum moves
        return (int) (sum - (long) min * nums.length);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna