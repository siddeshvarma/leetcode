class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(cnt!=0)ans=ans+ch;
                cnt++;
            }
            else{
                if(cnt!=1)ans=ans+ch;
                cnt--;
            }
        }return ans;
    }
}