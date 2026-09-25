class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] map = new boolean[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !map[i][j]) {
                    ans++;
                    dfs(i, j, grid, map);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] map) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '0' || map[i][j]) return;

        map[i][j] = true;

        dfs(i + 1, j, grid, map); // down
        dfs(i - 1, j, grid, map); // up
        dfs(i, j + 1, grid, map); // right
        dfs(i, j - 1, grid, map); // left
    }
}