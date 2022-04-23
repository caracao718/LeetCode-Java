package Graph;

public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
    }
}
