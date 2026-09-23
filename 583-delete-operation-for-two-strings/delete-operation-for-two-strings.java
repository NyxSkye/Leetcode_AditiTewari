class Solution {
    public int count(int i, int j, String t1, String t2, int[][] dp) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = 1 + count(i + 1, j + 1, t1, t2, dp);
        }
        int skipT1 = count(i + 1, j, t1, t2, dp);
        int skipT2 = count(i, j + 1, t1, t2, dp);
        return dp[i][j] = Math.max(skipT1, skipT2);
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        int m = word1.length();
        int n = word2.length();
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int lcs = count(0, 0, word1, word2, dp);        
        return m + n - (2 * lcs);
    }
}