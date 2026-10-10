
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];
        long total = 0;
        long maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (total <= k) {
            return 0;
        }

        long low = 0, high = maxDiff;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long threshold = low;
        long used = 0;

        for (long d : diff) {
            if (d > threshold) {
                used += d - threshold;
            }
        }

        long remaining = k - used;
        long answer = 0;

        for (long d : diff) {
            long x = Math.min(d, threshold);

            if (remaining > 0 && d >= threshold) {
                x--;
                remaining--;
            }

            answer += x * x;
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna