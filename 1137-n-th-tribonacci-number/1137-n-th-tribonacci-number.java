class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return helperfunction(n , dp);
    }

    public int helperfunction(int n , int[] dp){
          if(n==0) return 0;
          if(n==1) return 1;
          if(n==2) return 1;
          if(dp[n]!= -1) return dp[n];
          dp[n] = helperfunction(n-1 , dp) + helperfunction(n-2 , dp) + helperfunction(n-3 , dp);
          return dp[n];
    }
}