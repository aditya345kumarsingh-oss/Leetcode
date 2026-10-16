
import java.util.Arrays;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        // Store the last occurrence of each value
        int[] last = new int[100001];
        Arrays.fill(last, -1);

        SegmentTree tree = new SegmentTree(n);
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int previous = last[nums[i]];

            // Increase distinct counts for these starting positions
            tree.update(previous + 1, i);

            // Sum of squares for all subarrays ending at i
            answer = (answer + tree.getSquareSum()) % MOD;

            last[nums[i]] = i;
        }

        return (int) answer;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] squareSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        long getSquareSum() {
            return squareSum[1];
        }

        void apply(int node, int left, int right, long delta) {
            long len = right - left + 1L;
            delta %= MOD;

            // (x + delta)^2 = x^2 + 2*x*delta + delta^2
            squareSum[node] = (
                squareSum[node]
                + (2L * delta % MOD) * sum[node] % MOD
                + (delta * delta % MOD) * (len % MOD) % MOD
            ) % MOD;

            sum[node] = (
                sum[node] + delta * (len % MOD)
            ) % MOD;

            lazy[node] = (lazy[node] + delta) % MOD;
        }

        void pushDown(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;

            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);

            lazy[node] = 0;
        }

        void update(int queryLeft, int queryRight) {
            if (queryLeft > queryRight) {
                return;
            }

            update(1, 0, n - 1, queryLeft, queryRight);
        }

        void update(
            int node, int left, int right,
            int queryLeft, int queryRight
        ) {
            if (queryLeft <= left && right <= queryRight) {
                apply(node, left, right, 1);
                return;
            }

            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            if (queryLeft <= mid) {
                update(
                    node * 2, left, mid,
                    queryLeft, queryRight
                );
            }

            if (queryRight > mid) {
                update(
                    node * 2 + 1, mid + 1, right,
                    queryLeft, queryRight
                );
            }

            sum[node] = (
                sum[node * 2] + sum[node * 2 + 1]
            ) % MOD;

            squareSum[node] = (
                squareSum[node * 2]
                + squareSum[node * 2 + 1]
            ) % MOD;
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna