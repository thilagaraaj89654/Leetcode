class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] grid, int r, int c, int length) {
        if (isAllSame(grid, r, c, length)) {
            return new Node(grid[r][c] == 1, true);
        }
        int half = length / 2;
        Node topLeft = build(grid, r, c, half);
        Node topRight = build(grid, r, c + half, half);
        Node bottomLeft = build(grid, r + half, c, half);
        Node bottomRight = build(grid, r + half, c + half, half);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    private boolean isAllSame(int[][] grid, int r, int c, int length) {
        int val = grid[r][c];
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}