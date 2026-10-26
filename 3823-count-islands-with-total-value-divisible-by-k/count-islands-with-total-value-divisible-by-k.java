class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                  
                    long sum=dfs(grid,i,j);
                    if(sum%k==0){
                        ans=ans+1;
                    }
                }
            }
        }return ans;
    }
    public long dfs(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0){
            return 0;
        }
        //temp=temp+grid[i][j];
        long val=grid[i][j];
        grid[i][j]=0;
        long up=dfs(grid,i-1,j);
        long down=dfs(grid,i+1,j);
        long left=dfs(grid,i,j-1);
        long right=dfs(grid,i,j+1);

        return val+up+down+left+right;
    }
}