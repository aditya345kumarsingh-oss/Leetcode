class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[] dirs = {-1, 0, 1, 0, -1};

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Skip water or already visited cells
                if (grid[i][j] == 0) {
                    continue;
                }

                long sum = grid[i][j];

                // Mark as visited before adding to stack
                grid[i][j] = 0;
                stack.push(i * n + j);

                while (!stack.isEmpty()) {
                    int cell = stack.pop();

                    int x = cell / n;
                    int y = cell % n;

                    // Explore four directions
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dirs[d];
                        int ny = y + dirs[d + 1];

                        if (nx >= 0 && nx < m &&
                            ny >= 0 && ny < n &&
                            grid[nx][ny] > 0) {

                            sum += grid[nx][ny];

                            // Mark visited and add to stack
                            grid[nx][ny] = 0;
                            stack.push(nx * n + ny);
                        }
                    }
                }

                // Check the total value of this island
                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna