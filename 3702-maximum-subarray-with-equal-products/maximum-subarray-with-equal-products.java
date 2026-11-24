class Solution {
    public int maxLength(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            int gcd=temp;
            int lcm=temp;
            for(int j=i+1;j<nums.length;j++){
                temp=temp*nums[j];
                lcm=lcm(lcm,nums[j]);
                gcd=gcd(gcd,nums[j]);
                if(temp==(lcm*gcd)){
                    ans=Math.max(ans,(j-i)+1);
                }
            }
            if(temp==(lcm*gcd)){
                    ans=Math.max(ans,(nums.length-i));
                }
        }return ans;
    }
    public int lcm(int a,int b){
        return (a / gcd(a, b)) * b;
    }
    public int gcd(int a,int b){      
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}