class Solution {
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i!=0 || j!=0){
                    int left = Integer.MAX_VALUE;
                    int top = Integer.MAX_VALUE;
                  if(j>0){
                    left = grid[i][j-1];
                  }
                  if(i>0){
                    top = grid[i-1][j];
                  }

                  grid[i][j] += Math.min(left,top);
                }
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}