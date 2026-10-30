class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        genrate(n,ans,0,0,"");
        return ans;
    }
    public void genrate(int n,List<String>ans,int open,int close,String paran){
        if(paran.length()==n*2){
            ans.add(paran);
            return ;
        }

        if(open<n){
            genrate(n,ans,open+1,close,paran+'(');
        }
        if(close<open)
        genrate(n,ans,open,close+1,paran+')');
    }
    
}