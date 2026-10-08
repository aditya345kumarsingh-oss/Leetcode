class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Check if current string is valid
                if (isValid(current)) {
                    ans.add(current);
                    found = true;
                }

                // Don't generate strings with more removals
                if (found) {
                    continue;
                }

                // Remove one parenthesis at a time
                for (int j = 0; j < current.length(); j++) {

                    char ch = current.charAt(j);

                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next =
                        current.substring(0, j)
                        + current.substring(j + 1);

                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            // Minimum removals found
            if (found) {
                break;
            }
        }

        return ans;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } 
            else if (ch == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna