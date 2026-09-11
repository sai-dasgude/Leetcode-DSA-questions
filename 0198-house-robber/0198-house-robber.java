class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        return helperfunction(nums,dp ,nums.length-1);

    }

    public int helperfunction(int[] nums , int[] dp , int pos){
        if(pos==0) return nums[pos];
        if(pos<0) return 0;

        if(dp[pos]!=-1) return dp[pos];
        int pick = nums[pos] + helperfunction(nums,dp,pos-2);
        int nopick = helperfunction(nums,dp,pos-1);
        dp[pos] = Math.max(pick,nopick);
        return dp[pos];
    }
}