class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            }

            else {
                int inside = stack.pop();

                int value;

                if (inside == 0) {
                    value = 1;
                } else {
                    value = 2 * inside;
                }

                int previous = stack.pop();

                stack.push(previous + value);
            }
        }

        return stack.peek();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna