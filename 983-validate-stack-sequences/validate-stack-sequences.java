class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      Stack<Integer>st=new Stack<>();
      int i=0;
      int j=0;
      while(i<pushed.length && j<popped.length){
            if(!st.isEmpty()){
                if(st.peek()==popped[j]){
                    st.pop();
                    j++;
                }
                else{
                    st.push(pushed[i]);
                    i++;
                }
            }
            else{
                st.push(pushed[i]);
                i++;
            }
      }
      while(j<popped.length){
            if(st.peek()==popped[j]){
                    st.pop();
                    j++;
            }
            else return false;
      }
      return st.isEmpty(); 
    }
}