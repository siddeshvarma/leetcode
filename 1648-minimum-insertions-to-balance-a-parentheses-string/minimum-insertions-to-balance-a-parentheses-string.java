// class Solution {
//     public int minInsertions(String s) {
//         int ans=0;
//         int open=0;
//         int close=0;
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(ch=='('){
//                 if(close==1){
//                     close=0;
//                     open--;
//                     ans++;
//                 }
//                 open++;
//             }
//             else{
//                 close++;
//                 if(close==2){
//                     if(open==0)ans++;
//                     else
//                     open--;
//                     close=0;
//                 }
                
//             }
//         }
//         if(close==0 && open!=0){
//             ans=ans+(open*2);
//         }
//         if(close==1){
//             if(open==0)ans=ans+2;
//             else ans=ans+1+((open-1)*2);
//         }
//         if(close==2){
//             if(open==0)ans=ans+1;
//             else ans=ans+(open-1)*2;
//         }return ans;
        
//     }
// }



class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int closeNeeded = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(closeNeeded%2!=0){
                    count++;
                    closeNeeded--;
                }
                closeNeeded+=2;
            }
            else if(s.charAt(i)==')'){
                closeNeeded--;
                if(closeNeeded<0){
                    count++;
                    closeNeeded+=2;
                }

            }
           
            
        }
       

        return count+closeNeeded;
        
    }
}
