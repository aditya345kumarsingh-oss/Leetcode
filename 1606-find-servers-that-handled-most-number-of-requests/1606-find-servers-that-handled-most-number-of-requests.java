import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] count = new int[k];
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int endTime = startTime + load[i];
            
            while (!busy.isEmpty() && busy.peek()[0] <= startTime) {
                available.add(busy.poll()[1]);
            }
            
            if (available.isEmpty()) {
                continue;
            }
            
            Integer server = available.ceiling(i % k);
            if (server == null) {
                server = available.first();
            }
            
            available.remove(server);
            busy.offer(new int[]{endTime, server});
            count[server]++;
            maxRequests = Math.max(maxRequests, count[server]);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna