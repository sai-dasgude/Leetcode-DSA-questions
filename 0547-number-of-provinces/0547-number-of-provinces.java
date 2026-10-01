class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int provinces = 0;

        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                dfs(isConnected , i , visited);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected , int index , int[] visited){
        visited[index] = 1;

        for(int i=0;i<isConnected.length;i++){
            if(isConnected[index][i]==1 && visited[i]==0){
                dfs(isConnected , i , visited);
            }
        }
    }
}