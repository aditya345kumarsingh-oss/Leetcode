
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Check every divisor of n
        for (int k = 1; k <= n / k; k++) {
            if (n % k == 0) {
                if (isSortable(nums, k)) {
                    ans += k;
                }

                int other = n / k;
                if (other != k && isSortable(nums, other)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int min = nums[start];
            int max = nums[start];
            int descents = 0;

            // Check this block and its circular rotation
            for (int j = start; j < start + k; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                int next = (j + 1 == start + k)
                        ? start : j + 1;

                if (nums[j] > nums[next]) {
                    descents++;
                }
            }

            // A block must have at most one circular descent
            if (descents > 1) {
                return false;
            }

            // Blocks must join in sorted order
            if (prevMax > min) {
                return false;
            }

            prevMax = max;
        }

        return true;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna