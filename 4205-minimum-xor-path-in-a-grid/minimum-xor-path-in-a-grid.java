// class Solution {
//     int val=Integer.MAX_VALUE;
//     public int minCost(int[][] grid) {
//         int temp=0;
//         int i=0,j=0;
        
//         min(grid,i,j,temp);
//         return val;
//     }
//     public void min(int[][] grid ,int i,int j,int temp){
//             if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
//             return ;
//         }
//         temp=temp^grid[i][j];
//         if(i==grid.length-1 && j==grid[i].length-1){
//             val=Math.min(val,temp);
//            return ;
//         }
//         min(grid,i+1,j,temp);
//         min(grid,i,j+1,temp);
//     }
// }
//TLE----


class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                for (int x = 0; x < 1024; x++) {

                    if (i > 0 && dp[i - 1][j][x]) {
                        dp[i][j][x ^ grid[i][j]] = true;
                    }

                    if (j > 0 && dp[i][j - 1][x]) {
                        dp[i][j][x ^ grid[i][j]] = true;
                    }
                }
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
