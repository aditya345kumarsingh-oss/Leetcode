class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] best = new int[n];

        int left = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int currentLen = right - left + 1;

                // Check if a previous non-overlapping subarray exists
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {

                    ans = Math.min(
                        ans,
                        currentLen + best[left - 1]
                    );
                }

                minLen = Math.min(minLen, currentLen);
            }

            best[right] = minLen;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}