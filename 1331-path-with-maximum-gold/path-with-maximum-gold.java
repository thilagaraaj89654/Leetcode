class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0) {
                    maxGold = Math.max(maxGold, backtrack(grid, r, c));
                }
            }
        }
        return maxGold;
    }

    private int backtrack(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;

        int currentGold = grid[r][c];
        grid[r][c] = 0;

        int maxPath = 0;
        maxPath = Math.max(maxPath, backtrack(grid, r + 1, c));
        maxPath = Math.max(maxPath, backtrack(grid, r - 1, c));
        maxPath = Math.max(maxPath, backtrack(grid, r, c + 1));
        maxPath = Math.max(maxPath, backtrack(grid, r, c - 1));

        grid[r][c] = currentGold;
        return currentGold + maxPath;
    }
}