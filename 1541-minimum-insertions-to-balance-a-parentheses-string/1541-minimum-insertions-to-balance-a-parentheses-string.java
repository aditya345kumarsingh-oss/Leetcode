
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // If need is odd, insert one ')' first
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }

                // Each '(' needs two ')'
                need += 2;
            } else {
                // Use one required ')'
                need--;

                // No '(' available to match this ')'
                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        // Insert any remaining required ')'
        return insertions + need;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna