
import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Store: number, digit sum, original index
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digitSum(nums[i]);
            arr[i][2] = i;
        }

        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Count cycles in the permutation
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna