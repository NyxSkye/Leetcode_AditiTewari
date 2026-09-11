class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -101);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, solve(grid, 0, j, n, m, dp));
        }
        return ans;//it take min possible colmn value...
        // return solve(grid,0,0,n,m);
    }

    public int solve(int[][] grid, int i, int j, int n, int m, int[][] dp) {

        if (i == n - 1)
            return grid[i][j];

        if (dp[i][j] != -101) {
            return dp[i][j];
        }
        int sum = Integer.MAX_VALUE;
        for (int k = 0; k < m; k++) {
            if(j!=k){
                sum=Math.min(sum,solve(grid,i+1,k,n,m,dp));
            }
        }
        dp[i][j] = grid[i][j] + sum;
        return dp[i][j];
    }
}
