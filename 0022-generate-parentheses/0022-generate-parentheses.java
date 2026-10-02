import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    private void backtrack(
        List<String> ans,
        String current,
        int open,
        int close,
        int n
    ) {

        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // Add '(' if we still have opening brackets left
        if (open < n) {
            backtrack(
                ans,
                current + "(",
                open + 1,
                close,
                n
            );
        }

        // Add ')' only if it keeps the string valid
        if (close < open) {
            backtrack(
                ans,
                current + ")",
                open,
                close + 1,
                n
            );
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna