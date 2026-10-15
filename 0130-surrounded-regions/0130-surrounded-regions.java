class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] checked_arr = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<col;i++){
            if(board[0][i]=='O'){
                int[] temp = {0 , i};
                queue.add(temp);
            }
            if(board[row-1][i]=='O'){
                int[] temp = {row-1 , i};
                queue.add(temp);
                }

                checked_arr[0][i] = 1;
                checked_arr[row-1][i] = 1;
        }

        for(int i=0;i<row;i++){
            if(board[i][0]=='O'){
                int[] temp = {i , 0};
                queue.add(temp);
            }
            if(board[i][col-1]=='O'){
                int[] temp = {i , col-1};
                queue.add(temp);
                }

                checked_arr[i][0] = 1;
                checked_arr[i][col-1] = 1;

        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if(r-1>=0){
                 if(board[r-1][c]=='O' && checked_arr[r-1][c]==0){
                    int[] temp = {r-1 , c};
                    queue.add(temp);
                    checked_arr[r-1][c] = 1;
                 }
            }
            if(c+1<col){
                 if(board[r][c+1]=='O' && checked_arr[r][c+1]==0){
                    int[] temp = {r , c+1};
                    queue.add(temp);
                    checked_arr[r][c+1] = 1;
                 }

            }
            if(r+1<row){
                 if(board[r+1][c]=='O' && checked_arr[r+1][c]==0){
                    int[] temp = {r+1 , c};
                    queue.add(temp);
                    checked_arr[r+1][c] = 1;
                 }

            }
            if(c-1>=0){
                 if(board[r][c-1]=='O' && checked_arr[r][c-1]==0){
                    int[] temp = {r , c-1};
                    queue.add(temp);
                    checked_arr[r][c-1] = 1;
                       }
        }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O' && checked_arr[i][j]==0){
                     board[i][j] = 'X';
                }
            }
        

    }


}
}