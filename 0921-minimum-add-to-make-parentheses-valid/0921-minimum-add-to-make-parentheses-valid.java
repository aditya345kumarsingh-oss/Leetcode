class Solution {
    public int minAddToMakeValid(String s) {

        int open = 0;
        int add = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            }

            else { // ch == ')'

                if (open > 0) {
                    open--;
                }

                else {
                    add++;
                }
            }
        }

        return add + open;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna