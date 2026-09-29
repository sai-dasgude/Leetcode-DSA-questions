
class Solution {

    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        for(int r = 0; r < rows; r++) {
            for(int c1 = 0; c1 < cols; c1++) {
                Arrays.fill(dp[r][c1], -1);
            }
        }

        return helperfunction(
            grid,
            0,
            0,
            cols - 1,
            dp
        );
    }


    public int helperfunction(
        int[][] grid,
        int r,
        int c1,
        int c2,
        int[][][] dp
    ) {

        int rows = grid.length;
        int cols = grid[0].length;


        // invalid position
        if(c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) {
            return -100000000;
        }


        // last row
        if(r == rows - 1) {

            if(c1 == c2) {
                return grid[r][c1];
            }

            return grid[r][c1] + grid[r][c2];
        }


        // already calculated
        if(dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }


        int max = -100000000;


        for(int i = -1; i <= 1; i++) {

            for(int j = -1; j <= 1; j++) {

                int cherries;

                if(c1 == c2) {
                    cherries = grid[r][c1];
                }
                else {
                    cherries =
                        grid[r][c1]
                        +
                        grid[r][c2];
                }


                int next =
                    helperfunction(
                        grid,
                        r + 1,
                        c1 + i,
                        c2 + j,
                        dp
                    );


                int total =
                    cherries + next;


                max =
                    Math.max(max, total);
            }
        }


        dp[r][c1][c2] = max;

        return dp[r][c1][c2];
    }
}