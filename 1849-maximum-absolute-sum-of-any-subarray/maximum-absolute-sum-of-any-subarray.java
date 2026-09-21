class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            ans=Math.max(ans,sum);
            if(sum<0)sum=0;
          
        }
        int sum1=0;
        int ans1=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum1=sum1+nums[i];
            ans1=Math.min(ans1,sum1);
            if(sum1>0)sum1=0;
        }
        return Math.max(Math.abs(ans1),ans);
    }
}