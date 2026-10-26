class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int cnt=dfs(grid,i,j);
                    ans=Math.max(ans,cnt);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int i,int j){
        int m=grid.length;
        if(i<0 || j<0 || i>=m || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int up=dfs(grid,i-1,j);
        int down=dfs(grid,i+1,j);
        int left=dfs(grid,i,j-1);
        int right=dfs(grid,i,j+1);

        return 1+up+down+left+right;
    }
}