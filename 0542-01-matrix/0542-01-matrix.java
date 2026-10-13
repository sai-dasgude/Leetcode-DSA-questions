class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int row = mat.length;
        int col = mat[0].length;
        int[][] visited = new int[row][col];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<col;j++){
                     if(mat[i][j]==0){
                        int[] curr = {i,j};
                        queue.offer(curr);
                        visited[i][j] = 1;
                     }
            }
        }
         int currlevel = 1;
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0;i<size;i++){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];

            if(r-1>=0){
                if(visited[r-1][c]==0){
                    if(mat[r-1][c]==1){
                        mat[r-1][c] = currlevel;
                        visited[r-1][c] = 1;
                        int[] newarr = {r-1 , c};
                        queue.offer(newarr);
                    }
                }
            }
            if(c+1<col){
                if(visited[r][c+1]==0){
                    if(mat[r][c+1]==1){
                        mat[r][c+1] = currlevel;
                        visited[r][c+1] = 1;

                        int[] newarr = {r , c+1};
                        queue.offer(newarr);

                    }
                }

            }
            if(r+1<row){
                if(visited[r+1][c]==0){
                    if(mat[r+1][c]==1){
                        mat[r+1][c] = currlevel;
                        visited[r+1][c] = 1;

                        int[] newarr = {r+1 , c};
                        queue.offer(newarr);

                    }
                }

            }
            if(c-1>=0){
                if(visited[r][c-1]==0){
                    if(mat[r][c-1]==1){
                        mat[r][c-1] = currlevel;
                        visited[r][c-1] = 1;
                        int[] newarr = {r , c-1};
                        queue.offer(newarr);

                    }
                }

            }
            }
            currlevel++;
        }

        return mat;
    }
}