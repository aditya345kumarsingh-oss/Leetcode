class Solution {

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // pal[i][j] = true if substring i...j is palindrome
        boolean[][] pal = new boolean[n][n];

        // Step 1: Find all palindrome substrings
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        // dp[i] = maximum palindromes using first i characters
        int[] dp = new int[n + 1];

        // Step 2: Find maximum non-overlapping palindromes
        for (int end = 1; end <= n; end++) {

            // Don't take a palindrome ending here
            dp[end] = dp[end - 1];

            for (int start = 0; start <= end - k; start++) {

                // substring start to end-1
                if (pal[start][end - 1]) {

                    dp[end] = Math.max(
                        dp[end],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}