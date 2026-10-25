class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Flood-fill all land cells connected to the boundary
        for (int r = 0; r < m; r++) {
            if (grid[r][0] == 0) dfs(grid, r, 0, m, n);
            if (grid[r][n - 1] == 0) dfs(grid, r, n - 1, m, n);
        }
        for (int c = 0; c < n; c++) {
            if (grid[0][c] == 0) dfs(grid, 0, c, m, n);
            if (grid[m - 1][c] == 0) dfs(grid, m - 1, c, m, n);
        }

        // Step 2: Count the remaining enclosed islands
        int closedIslands = 0;
        for (int r = 1; r < m - 1; r++) {
            for (int c = 1; c < n - 1; c++) {
                if (grid[r][c] == 0) {
                    closedIslands++;
                    dfs(grid, r, c, m, n);
                }
            }
        }

        return closedIslands;
    }

    private void dfs(int[][] grid, int r, int c, int m, int n) {
        // Stop if out of bounds or already water (1)
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) {
            return;
        }

        // Mark current cell as visited by turning it into water
        grid[r][c] = 1;

        // Explore 4-directionally
        dfs(grid, r + 1, c, m, n);
        dfs(grid, r - 1, c, m, n);
        dfs(grid, r, c + 1, m, n);
        dfs(grid, r, c - 1, m, n);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna