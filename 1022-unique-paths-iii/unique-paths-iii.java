class Solution {
    private int totalPaths = 0;

    public int uniquePathsIII(int[][] grid) {
        int emptyCells = 1;
        int startR = 0, startC = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    startR = r;
                    startC = c;
                } else if (grid[r][c] == 0) {
                    emptyCells++;
                }
            }
        }

        backtrack(grid, startR, startC, emptyCells);
        return totalPaths;
    }

    private void backtrack(int[][] grid, int r, int c, int remaining) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) return;

        if (grid[r][c] == 2) {
            if (remaining == 0) totalPaths++;
            return;
        }

        grid[r][c] = -1;

        backtrack(grid, r + 1, c, remaining - 1);
        backtrack(grid, r - 1, c, remaining - 1);
        backtrack(grid, r, c + 1, remaining - 1);
        backtrack(grid, r, c - 1, remaining - 1);

        grid[r][c] = 0;
    }
}