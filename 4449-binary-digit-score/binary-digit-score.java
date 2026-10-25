class Solution {
    public int calculateScore(int a, int b) {
        int[] arr=new int[]{1,2,4,8,16,32,64,128};
        int cnt1=0;
        int cnt2=0;
        for(int i=arr.length-2;i>=0;i--){
            if(a>=arr[i]){
                a=a-arr[i];
                cnt1++;
            }
            if(b>=arr[i]){
                b=b-arr[i];
                cnt2++;
            }
        }
        return cnt1>=cnt2?(cnt1*cnt2):(cnt2/cnt1);
    }
}