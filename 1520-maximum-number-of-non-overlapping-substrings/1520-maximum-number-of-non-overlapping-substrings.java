import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<String> ans = new ArrayList<>();

        int previousEnd = -1;

        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            // Start only from first occurrence
            if (first[ch] != i) {
                continue;
            }

            int end = last[ch];
            boolean valid = true;

            // Expand substring if necessary
            for (int j = i; j <= end; j++) {

                int current = s.charAt(j) - 'a';

                // Character starts before our substring
                if (first[current] < i) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[current]);
            }

            if (valid) {

                if (i > previousEnd) {

                    // No overlap
                    ans.add(s.substring(i, end + 1));

                } else {

                    // Overlap -> replace previous with smaller substring
                    ans.set(
                        ans.size() - 1,
                        s.substring(i, end + 1)
                    );
                }

                previousEnd = end;
            }
        }

        return ans;
    }
}