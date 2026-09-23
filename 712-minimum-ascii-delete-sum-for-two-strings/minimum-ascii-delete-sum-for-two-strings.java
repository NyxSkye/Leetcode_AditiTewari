class Solution {
    public int count(int i, int j, String t1, String t2, int[][] dp) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = (int) t1.charAt(i) + count(i + 1, j + 1, t1, t2, dp);
        }
        int skipT1 = count(i + 1, j, t1, t2, dp);
        int skipT2 = count(i, j + 1, t1, t2, dp);
        return dp[i][j] = Math.max(skipT1, skipT2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int totalSum = 0;
        for (int i = 0; i < s1.length(); i++){
            totalSum+=s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++){
            totalSum+=s2.charAt(i);
        }        
        int res = count(0, 0, s1, s2, dp);
        return totalSum - (2 *res);
    }
}