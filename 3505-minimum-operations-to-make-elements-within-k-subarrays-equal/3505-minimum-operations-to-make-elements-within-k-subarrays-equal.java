class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // 1. Coordinate Compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[m++] = sorted[i];
            }
        }

        Fenwick treeCount = new Fenwick(m);
        FenwickSum treeSum = new FenwickSum(m);

        // Precompute cost for every window of size x
        long[] windowCost = new long[n];
        int half = (x + 1) / 2;

        for (int i = 0; i < n; i++) {
            int rank = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
            treeCount.add(rank, 1);
            treeSum.add(rank, nums[i]);

            if (i >= x) {
                int oldRank = Arrays.binarySearch(sorted, 0, m, nums[i - x]) + 1;
                treeCount.add(oldRank, -1);
                treeSum.add(oldRank, -nums[i - x]);
            }

            if (i >= x - 1) {
                // Find median index using binary lifting
                int medianRank = treeCount.findKth(half);
                long medianVal = sorted[medianRank - 1];

                long leftCount = treeCount.query(medianRank);
                long leftSum = treeSum.query(medianRank);

                long rightCount = x - leftCount;
                long rightSum = treeSum.query(m) - leftSum;

                windowCost[i] = (leftCount * medianVal - leftSum) + (rightSum - rightCount * medianVal);
            }
        }

        // 2. Dynamic Programming: dp[j][i]
        // Rolling DP across k to save memory
        long[] dpPrev = new long[n + 1];
        long[] dpCurr = new long[n + 1];
        long INF = (long) 1e16;

        Arrays.fill(dpPrev, 0);

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dpCurr, INF);
            for (int i = j * x; i <= n; i++) {
                // Option 1: Do not pick a subarray ending at index i - 1
                dpCurr[i] = dpCurr[i - 1];

                // Option 2: Pick subarray of size x ending at index i - 1
                if (dpPrev[i - x] != INF) {
                    dpCurr[i] = Math.min(dpCurr[i], dpPrev[i - x] + windowCost[i - 1]);
                }
            }
            System.arraycopy(dpCurr, 0, dpPrev, 0, n + 1);
        }

        return dpCurr[n];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        void add(int i, int delta) {
            for (; i <= n; i += i & -i) tree[i] += delta;
        }

        int query(int i) {
            int sum = 0;
            for (; i > 0; i -= i & -i) sum += tree[i];
            return sum;
        }

        int findKth(int k) {
            int idx = 0;
            for (int step = 1 << (31 - Integer.numberOfLeadingZeros(n)); step > 0; step >>= 1) {
                if (idx + step <= n && tree[idx + step] < k) {
                    idx += step;
                    k -= tree[idx];
                }
            }
            return idx + 1;
        }
    }

    static class FenwickSum {
        long[] tree;
        int n;

        FenwickSum(int n) {
            this.n = n;
            this.tree = new long[n + 1];
        }

        void add(int i, long delta) {
            for (; i <= n; i += i & -i) tree[i] += delta;
        }

        long query(int i) {
            long sum = 0;
            for (; i > 0; i -= i & -i) sum += tree[i];
            return sum;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna