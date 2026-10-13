
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        // Step 1: Square every element
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        // Step 2: Sort the squares
        Arrays.sort(squares);

        // Step 3: Subtract the smaller half
        // and add the larger half
        int mid = n / 2;
        long sum = 0;

        for (int i = 0; i < mid; i++) {
            sum -= squares[i];
        }

        for (int i = mid; i < n; i++) {
            sum += squares[i];
        }

        return sum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna