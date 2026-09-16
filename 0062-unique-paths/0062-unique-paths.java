class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return helperfunction(m,n,2 , 1 , dp) + helperfunction(m,n,1 , 2 , dp);
    }

    public int helperfunction(int m , int n , int currrow , int currcol , int[][] dp){
        if(currrow>m) return 0;
        if(currcol>n) return 0;

        if(currrow==m && currcol==n) return 1;
        if(dp[currrow][currcol]!=-1) return dp[currrow][currcol];

        return dp[currrow][currcol] = helperfunction(m,n,currrow+1 , currcol,dp) + helperfunction(m,n,currrow , currcol+1,dp);
    }
}