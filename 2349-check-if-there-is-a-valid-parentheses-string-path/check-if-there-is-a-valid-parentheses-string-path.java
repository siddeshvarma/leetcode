// class Solution {
//     public boolean hasValidPath(char[][] grid) {
//         if(grid[0][0] == ')' || grid[grid.length - 1][grid[grid.length - 1].length - 1]=='(')return false;
//         int leftBracket=0;
//         int rightBracket=0;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[i].length;j++){
//                 if(grid[i][j]=='(')leftBracket++;
//                 else rightBracket++;
//             }
//         }
//         if(leftBracket>=rightBracket)return true;
//         return false;
//     }
// }


class Solution {

    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        if (grid[0][0] == ')')
            return false;

        if (grid[grid.length - 1][grid[0].length - 1] == '(')
            return false;

        int length = grid.length + grid[0].length - 1;

        if (length % 2 != 0)
            return false;

        dp = new Boolean[grid.length][grid[0].length][length + 1];

        return solve(grid, 0, 0, 0);
    }

    public boolean solve(char[][] grid, int i, int j, int balance) {

        // Current bracket
        if (grid[i][j] == '(')
            balance++;
        else
            balance--;

        // Invalid balance
        if (balance < 0)
            return false;

        // Destination
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return balance == 0;

        // Already calculated
        if (dp[i][j][balance] != null)
            return dp[i][j][balance];

        boolean ans = false;

        // DOWN
        if (i + 1 < grid.length) {
            ans = solve(grid, i + 1, j, balance);
        }

        // RIGHT
        if (!ans && j + 1 < grid[0].length) {
            ans = solve(grid, i, j + 1, balance);
        }

        dp[i][j][balance] = ans;

        return ans;
    }
}