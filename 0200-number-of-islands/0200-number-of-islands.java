class Solution {
    public int numIslands(char[][] grid) {
        int[][] isVisited = new int[grid.length][grid[0].length];
        int count = 0;
        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                if(isVisited[m][n]==0 && grid[m][n]=='1'){

                    isVisited[m][n] = 1;
                    Queue<int[]> queue = new LinkedList<>();
                      int[] curr = {m , n};
                    queue.offer(curr);

                      while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        int i = temp[0];
                        int j = temp[1];
                        

                        // int[] topleft = {i-1 , j-1};
                        // if(topleft[0] >=0 && topleft[1]>=1){
                        //     if(isVisited[i-1][j-1]==0 && grid[i-1][j-1]=='1'){
                        //         queue.offer(topleft);
                        //         isVisited[i-1][j-1] = 1;
                        //     }
                        // }

                        int[] top = {i-1 , j};
                        if(top[0]>= 0){
                            if(isVisited[i-1][j]==0 && grid[i-1][j]=='1'){
                                queue.offer(top);
                                isVisited[i-1][j] = 1;
                            }
                        }

                        // int[] topright = {i-1 , j+1};
                        // if(topright[0] >= 0 && topright[1] < grid[0].length){
                        //     if(isVisited[i-1][j+1]==0 && grid[i-1][j+1]=='1'){
                        //         queue.offer(topright);
                        //         isVisited[i-1][j+1] = 1;
                        //     }
                        // }

                        int[] left = {i , j-1};
                        if(left[1]>=0){
                            if(isVisited[i][j-1]==0 && grid[i][j-1]=='1'){
                                queue.offer(left);
                                isVisited[i][j-1] = 1;
                            }
                        }

                        int[] right = {i , j+1};
                        if(right[1]< grid[0].length){
                            if(isVisited[i][j+1]==0 && grid[i][j+1]=='1'){
                                queue.offer(right);
                                isVisited[i][j+1] = 1;
                            }
                        }

                        // int[] bottomleft = {i+1 , j-1};
                        // if(bottomleft[0] < grid.length && bottomleft[1] >= 0){
                        //     if(isVisited[i+1][j-1]==0 && grid[i+1][j-1]=='1'){
                        //         queue.offer(bottomleft);
                        //         isVisited[i+1][j-1] = 1;
                        //     }
                        // }

                        int[] bottom = {i+1 , j};
                        if(bottom[0]<grid.length){
                            if(isVisited[i+1][j]==0 && grid[i+1][j]=='1'){
                                queue.offer(bottom);
                                isVisited[i+1][j]=1;
                            }
                        }

                        // int[] bottomright = {i+1 , j+1};
                        // if(bottomright[0] < grid.length && bottomright[1] < grid[0].length){
                        //     if(isVisited[i+1][j+1]==0 && grid[i+1][j+1]=='1'){
                        //         queue.offer(bottomright);
                        //         isVisited[i+1][j+1]=1;
                        //     }
                        // }

                      }

                      count++;
                           
                }
            }
        }

        return count;
    }
}