class Solution {
    int avaRob(int i, int[]nums, int[]dp){
        if (i>=nums.length){
            return 0;
        }
        if (dp[i]!=-1){
            return dp[i];
        }
        int c1= nums[i]+avaRob(i+2,nums,dp);
        int c2= avaRob(i+1,nums,dp);
        int ans= Math.max(c1,c2);
        dp[i]=ans;
        return ans;
    }
    public int rob(int[] nums) {
        int[] dp= new int[101];
        Arrays.fill(dp, -1);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return avaRob(0, nums,dp);
    }
}
/* date change */
