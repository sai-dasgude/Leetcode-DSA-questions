class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<col;i++){
            if(grid[0][i]==1){
                int[] curr = {0 , i};
                grid[0][i] =0;
                queue.offer(curr);
            }
            if(grid[row-1][i]==1){
               int[] curr = {row-1 , i};
               queue.offer(curr);
               grid[row-1][i] = 0;
            }
        }

        for(int i=0;i<row;i++){
            if(grid[i][0]==1){
                int[] curr = {i,0};
                queue.offer(curr);
                grid[i][0] = 0;
            }
            if(grid[i][col-1]==1){
               int[] curr = {i,col-1};
               queue.offer(curr);
               grid[i][col-1] = 0;
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if(r-1>=0){
                if(grid[r-1][c]==1){
                    int[] temp = {r-1 , c};
                    queue.offer(temp);
                    grid[r-1][c] = 0;

                }
            }

            if(c+1<col){
                    if(grid[r][c+1]==1){
                    int[] temp = {r , c+1};
                    queue.offer(temp);
                    grid[r][c+1] = 0;

                }

            }
            if(r+1<row){
                 if(grid[r+1][c]==1){
                    int[] temp = {r+1 , c};
                    queue.offer(temp);
                    grid[r+1][c] = 0;

                }
   
            }
            if(c-1>=0){
                     if(grid[r][c-1]==1){
                    int[] temp = {r , c-1};
                    queue.offer(temp);
                    grid[r][c-1] = 0;

                }
   
            }
        }

       int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               if(grid[i][j]==1){
                count++;
               }
            }
        }

        return count;

    }
}