class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length-1;
        int col = obstacleGrid[0].length-1;


        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        if(obstacleGrid[row][col]==-1) return 0;


        

        

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(obstacleGrid[i][j]!=-1){
               if(j-1 >= 0){
                    if(obstacleGrid[i][j-1]!=-1){
                        obstacleGrid[i][j]+=obstacleGrid[i][j-1];
                    }
               }

               if(i-1 >=0){
                if(obstacleGrid[i-1][j] != -1){
                obstacleGrid[i][j]+=obstacleGrid[i-1][j];

                }
               }

                               if(i==0&&j==0) obstacleGrid[i][j] = 1;

              
                
                }
            }
        }
        return obstacleGrid[row][col];
    }
    }