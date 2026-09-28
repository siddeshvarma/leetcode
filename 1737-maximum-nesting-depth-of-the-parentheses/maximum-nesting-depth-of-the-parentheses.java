class Solution {
    public int maxDepth(String s) {
        int inc=0;
        int ans=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') inc++;//1
            if(ch==')') inc--;           
            ans=Math.max(ans,inc);
            
        } return ans;
    }
}