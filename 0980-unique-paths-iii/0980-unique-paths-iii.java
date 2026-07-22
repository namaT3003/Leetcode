class Solution {
     int paths = 0;
    int empty = 0;
    int startRow;
    int startCol;
    public int uniquePathsIII(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        dfs(grid, startRow, startCol, -1);

        return paths;
    }

    private void dfs(int[][] grid, int row, int col, int count) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
            return;
        }

        if (grid[row][col] == 2) {
            if (count == empty) {
                paths++;
            }
            return;
        }

        int temp = grid[row][col];
        grid[row][col] = -1;

        dfs(grid, row + 1, col, count + 1);
        dfs(grid, row - 1, col, count + 1);
        dfs(grid, row, col + 1, count + 1);
        dfs(grid, row, col - 1, count + 1);

        grid[row][col] = temp;
    }
}