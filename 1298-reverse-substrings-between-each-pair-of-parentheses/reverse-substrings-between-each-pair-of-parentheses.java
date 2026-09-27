class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=')'){
                st.push(ch);
            }
            else{
                String temp="";
                while(st.peek()!='('){
                    char ch1=st.pop();
                    temp=temp+ch1;
                }
                st.pop();
                for(int j=0;j<temp.length();j++){
                    st.push(temp.charAt(j));
                }
            }
        }
        String ans="";
        while(!st.isEmpty()){
            ans=ans+st.pop();
        }
        String finAns="";
        for(int i=ans.length()-1;i>=0;i--){
            finAns+=ans.charAt(i);
        }return finAns;

    }
}