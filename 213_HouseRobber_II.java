class Solution {
    int[][] dp = new int[101][2];
    int avaRob(int i, int[] nums, int f) {
        if (i == nums.length-1) {
            if(f==1){
                return 0;
            }
            return nums[i];
        }
        if (dp[i][f] != -1) {
            return dp[i][f];
        }
        if (i>=nums.length){
            return 0;
        }
        int nf=f;
        if (i==0){
            nf=1;
        }
        int c1 = nums[i] + avaRob(i + 2, nums,nf);
        int c2 = avaRob(i + 1, nums,f);
        int ans = Math.max(c1, c2);
        dp[i][f] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }        
        return avaRob(0, nums, 0);
    }
}
/* date change */
