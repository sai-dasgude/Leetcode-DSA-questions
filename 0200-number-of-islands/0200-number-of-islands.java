import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        int[][] directions = {
            {-1, 0}, // top
            {1, 0},  // bottom
            {0, -1}, // left
            {0, 1}   // right
        };

        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == '1') {

                    islands++;

                    grid[row][col] = '0';
                    queue.offer(new int[]{row, col});

                    while (!queue.isEmpty()) {

                        int[] current = queue.poll();
                        int currentRow = current[0];
                        int currentCol = current[1];

                        for (int[] direction : directions) {

                            int newRow = currentRow + direction[0];
                            int newCol = currentCol + direction[1];

                            if (newRow >= 0 && newRow < rows &&
                                newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol] == '1') {

                                grid[newRow][newCol] = '0';
                                queue.offer(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }
}