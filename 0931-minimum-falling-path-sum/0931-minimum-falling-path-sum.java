class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length-1;
        if(rows==0){
            return matrix[0][0];
        }else{
            for(int i=1;i<=rows;i++){
                for(int j=0;j<=rows;j++){
                    int prev = Integer.MAX_VALUE;
                    int curr = matrix[i-1][j];
                    int next = Integer.MAX_VALUE;

                    if(j-1 >= 0 ){
                        prev = matrix[i-1][j-1];
                    }

                    if(j+1 <=rows){
                        next = matrix[i-1][j+1];
                    }

                    matrix[i][j] += Math.min(prev , Math.min(curr,next));



                }
            }
            int min = matrix[rows][0];
            for(int i=1;i<=rows;i++){
                  if(matrix[rows][i]<min){
                    min = matrix[rows][i];
                  }
            }
            return min;
        }

    }
}