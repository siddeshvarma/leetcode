class Solution {
    public int secondHighest(String s) {
        int num1=Integer.MIN_VALUE;
        int num2=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int num=Integer.parseInt(String.valueOf(ch));
                if(num>num1){
                    num2=num1;
                    num1=num;
                }
                if(num1!=num && num>num2)num2=num;
            }
        }return num2==Integer.MIN_VALUE?-1:num2;
    }
}