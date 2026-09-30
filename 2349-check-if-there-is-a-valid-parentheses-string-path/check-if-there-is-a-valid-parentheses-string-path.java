class Solution {
    public Boolean[][][] memo;
    public boolean gen(int n, int m, char[][] grid, int i, int j, int balance) {
        if (i >= n || j >= m) {
            return false;
        }
        balance += (grid[i][j] == '(') ? 1 : -1;
        if (balance < 0) {
            return false;
        }
        if (i == n - 1 && j == m - 1) {
            return balance == 0;
        }
        if (memo[i][j][balance] != null) {
            return memo[i][j][balance];
        }
        boolean down = gen(n, m, grid, i + 1, j, balance);
        boolean right = gen(n, m, grid, i, j + 1, balance);
        return memo[i][j][balance] = (down || right);
    }
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        memo = new Boolean[n][m][n + m];
        return gen(n, m, grid, 0, 0, 0);
    }
}