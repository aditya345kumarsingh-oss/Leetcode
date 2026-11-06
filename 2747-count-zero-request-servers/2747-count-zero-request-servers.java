class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; ++i) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        
        // Sort queries by time to process them chronologically
        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[m];
        Map<Integer, Integer> cnt = new HashMap<>();
        int j = 0, k = 0;
        
        for (int i = 0; i < m; ++i) {
            int r = qs[i][0];
            int originalIndex = qs[i][1];
            int l = r - x;
            
            // Add logs that fall within the right bound (<= r)
            while (k < logs.length && logs[k][1] <= r) {
                cnt.put(logs[k][0], cnt.getOrDefault(logs[k][0], 0) + 1);
                k++;
            }
            
            // Remove logs that fall outside the left bound (< l)
            while (j < logs.length && logs[j][1] < l) {
                int serverId = logs[j][0];
                cnt.put(serverId, cnt.get(serverId) - 1);
                if (cnt.get(serverId) == 0) {
                    cnt.remove(serverId);
                }
                j++;
            }
            
            // Inactive servers = Total servers - Active servers in window
            ans[originalIndex] = n - cnt.size();
        }
        
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna