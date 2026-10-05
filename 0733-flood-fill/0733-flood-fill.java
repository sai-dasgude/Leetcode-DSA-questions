class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        int curr_color = image[sr][sc];
        image[sr][sc] = color;
        int[] temp = {sr , sc};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(temp);
        visited[sr][sc] = 1;
        while(!queue.isEmpty()){
            int[] curr_arr = queue.poll();
            int row = curr_arr[0];
            int col = curr_arr[1];

            if(col-1 >= 0){
                if(image[row][col-1]== curr_color && visited[row][col-1]==0){
                    image[row][col-1] = color;
                    int[] new_arr = {row , col -1};
                    visited[row][col-1]=1;
                    queue.offer(new_arr);
                }
            }

            if(row - 1 >= 0){
                if(image[row-1][col]==curr_color  && visited[row-1][col]==0){
                    image[row-1][col] = color;
                    int[] new_arr = {row-1 , col};
                    queue.offer(new_arr);
                    visited[row-1][col]=1;
                
                }
            }

            if(col + 1 < image[0].length){
                    if(image[row][col+1]==curr_color && visited[row][col+1]==0){
                    image[row][col+1] = color;
                    int[] new_arr = {row , col+1};
                    queue.offer(new_arr);
                    visited[row][col+1]=1;
                
                }

            }

            if(row + 1 < image.length){
                    if(image[row+1][col]==curr_color && visited[row+1][col]==0){
                    image[row+1][col] = color;
                    int[] new_arr = {row+1 , col};
                    queue.offer(new_arr);
                    visited[row+1][col]=1;
                
                }

            }

            

        }

        return image;
    }
}