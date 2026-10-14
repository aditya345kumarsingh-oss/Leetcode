
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Check if the required sum is possible
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);

            result.append(digit);
            sum -= digit;
        }

        return result.toString();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna