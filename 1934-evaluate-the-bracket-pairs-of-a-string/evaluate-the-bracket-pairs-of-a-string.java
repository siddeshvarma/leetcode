class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String>mp=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            mp.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        String ans="";
        String temp="";
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                flag=true;
            }
            else if(s.charAt(i)==')'){
                if(mp.containsKey(temp)){
                ans=ans+mp.get(temp);
                }
                else{
                    ans=ans+"?";
                }
                temp="";
                flag=false;
            }
            else if(flag){
                temp=temp+s.charAt(i);
            }
            else{
                ans=ans+s.charAt(i);
            }
        }return ans;
    }
}