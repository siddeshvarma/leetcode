class Solution {
    public int trailingZeroes(int n) { 
        // int mul=1;
        // if(n==0)return 0;
        // while(n!=0){
        //     mul*=n;
        //     n--;
        // }
        // if(mul<10 )return 0;
        // int ans=0;
        // int rem=mul%10;
        // mul=mul/10;
        // while(rem==0){
        //     ans++;
        //     rem=mul%10;
        //     rem=rem/10;
        // }return ans;

        int ans = 0;
        while(n > 0) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }
}