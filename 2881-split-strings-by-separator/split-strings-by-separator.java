class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String>ans=new ArrayList<>();
        for(int i=0;i<words.size();i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<words.get(i).length();j++){
                if(words.get(i).charAt(j)!=separator){
                    sb.append(words.get(i).charAt(j));
                }
                else{
                    if(sb.toString()!="")
                        ans.add(sb.toString());
                    sb=new StringBuilder("");
                }
            }
            if(sb.toString()!="")
            ans.add(sb.toString());
        }
        return ans;
    }
}