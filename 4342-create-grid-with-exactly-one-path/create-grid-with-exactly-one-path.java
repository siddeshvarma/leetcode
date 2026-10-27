class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<n;j++){
                if(i==0){
                    sb=sb.append(".");
                }
                else{
                    if(j==n-1){
                        sb=sb.append(".");
                    }
                    else{
                        sb=sb.append("#");
                    }
                }
            }
            ans[i]=sb.toString();
        }return ans;
    }
}