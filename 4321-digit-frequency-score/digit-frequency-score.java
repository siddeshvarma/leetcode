class Solution {
    public int digitFrequencyScore(int n) {
        int[] arr=new int[10];
        while(n!=0){
            int num=n%10;
            n=n/10;
            arr[num]++;
        }
        int ans=0;
        for(int i=0;i<10;i++){
            if(arr[i]!=0){
                ans+=i*arr[i];
            }
        }return ans;
    }
}