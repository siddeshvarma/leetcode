// class Solution {
//     public boolean checkValidString(String s) {
//         Stack<Character>st=new Stack<>();
//         int cntStar=0;
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(ch=='(')st.push(ch);
//             else if(ch==')'){
//                 if(st.isEmpty()){
//                     if(cntStar!=0)
//                     cntStar--;
//                     else return false;
//                 }
//                 else st.pop();               
//             }
//             else cntStar++;
//         }return st.isEmpty();
//     }
// } 71 out of 84

class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                low++;
                high++;
            }
            else if (ch == ')') {
                low--;
                high--;
            }
            else { // '*'
                low--;
                high++;
            }
            if (high < 0) {
                return false;
            }
            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }
}