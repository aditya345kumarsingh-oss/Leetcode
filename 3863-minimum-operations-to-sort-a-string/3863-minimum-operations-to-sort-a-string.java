
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Already sorted
        boolean sorted = true;
        char min = s.charAt(0);
        char max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
            }

            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        if (sorted) {
            return 0;
        }

        // Cannot sort a reversed string of length 2
        if (n == 2) {
            return -1;
        }

        // One operation is enough
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Check whether min or max is in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        return 3;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna