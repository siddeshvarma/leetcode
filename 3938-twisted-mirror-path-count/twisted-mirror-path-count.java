// class Solution {
//     long ans=0;
//     public int uniquePaths(int[][] grid) {
//         int i=0;
//         int j=0;
//         paths(grid,i,j);
//         System.out.print(ans);
//         return (int)ans%(1000000007);
//     }
//     public void paths(int[][] grid,int i,int j){
//         int m=grid.length;
//         int n=grid[0].length;
//         if(i>=m || j>=n)return;
//         if(i==m-1 && j==n-1){
//             ans++;
//             return;
//         }
//         System.out.println(ans);
//         //1st approch
//         // if(grid[i][j]==1){
//         //     paths(grid,i+1,j);
//         // }
//         // else
//         //     paths(grid,i,j+1);
//         // if(grid[i][j]==1){
//         //     paths(grid,i,j+1);
//         // }
//         // else
//         // paths(grid,i+1,j);

//         //2nd approch
//           // Move right
//         int r = i;
//         int c = j+1;
//         while(r < m && c < n && grid[r][c] == 1) {
//             r++;
//         }
//         if(r < m && c < n) {
//             paths(grid, r, c);
//         }
//         // Move down
//         r = i+1;
//         c = j;
//         while(r < m && c < n && grid[r][c] == 1) {
//             c++;
//         }
//         if(r < m && c < n) {
//             paths(grid, r, c);
//         }
//     }
// }

//final

import java.util.*;

class Solution {

    int[][][] dp;

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        return f(grid, 0, 0, 2);
    }

    int f(int[][] grid, int i, int j, int dir) {

        int m = grid.length;
        int n = grid[0].length;

        // Base case: invalid position
        if (i >= m || j >= n) {
            return 0;
        }

        // Base case: destination
        if (i == m-1 && j == n-1) {
            return 1;
        }

        // Already calculated
        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        int ans = 0;

        if (grid[i][j] == 0) {

            // Right
            ans = (ans + f(grid, i, j+1, 0)) % 1_000_000_007;

            // Down
            ans = (ans + f(grid, i+1, j, 1)) % 1_000_000_007;

        } else {

            // Mirror reflection
            if (dir == 0) {
                ans = f(grid, i+1, j, 1);
            } else {
                ans = f(grid, i, j+1, 0);
            }
        }

        return dp[i][j][dir] = ans;
    }
}