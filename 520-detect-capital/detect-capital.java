class Solution {
    public boolean detectCapitalUse(String s) {
        boolean upper=true;
        boolean lower=true;
        boolean uppLower=true;
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i)) && upper){
                upper=true;
            }
            else{
                upper=false;
            }
            if(Character.isLowerCase(s.charAt(i)) && lower){
                lower=true;
            }
            else{
                lower=false;
            }
            if(i!=0){
                if(Character.isLowerCase(s.charAt(i)) && uppLower){
                uppLower=true;
            }
            else{
                uppLower=false;
            }
            }
        }
        return lower || upper || (uppLower && Character.isUpperCase(s.charAt(0)));
    }
}