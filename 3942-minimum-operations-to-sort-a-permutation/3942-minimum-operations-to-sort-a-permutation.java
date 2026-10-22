class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int zeroIdx = -1;
        boolean isInc = true;
        boolean isDec = true;

        for (int k = 0; k < n; k++) {
            if (nums[k] == 0) {
                zeroIdx = k;
            }
            if ((nums[k] + 1) % n != nums[(k + 1) % n]) {
                isInc = false;
            }
            if ((nums[k] - 1 + n) % n != nums[(k + 1) % n]) {
                isDec = false;
            }
        }

        if (!isInc && !isDec) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        if (isInc) {
            if (zeroIdx == 0) {
                minOps = Math.min(minOps, 0);
            } else {
                // Option A: Rotate left zeroIdx times
                // Option B: Reverse, rotate left (n - zeroIdx) times, reverse
                minOps = Math.min(minOps, Math.min(zeroIdx, (n - zeroIdx) + 2));
            }
        }

        if (isDec) {
            // Option A: Reverse then rotate left
            int costRevRotate = n - zeroIdx;
            // Option B: Rotate left then reverse
            int costRotateRev = ((zeroIdx + 1) % n) + 1;
            minOps = Math.min(minOps, Math.min(costRevRotate, costRotateRev));
        }

        return minOps;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna