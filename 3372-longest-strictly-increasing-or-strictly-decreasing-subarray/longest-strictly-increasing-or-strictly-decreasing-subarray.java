class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                temp++;
            }
            else{
                ans=Math.max(ans,temp);
                temp=1;
            }
        }
        ans=Math.max(ans,temp);
        temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                temp++;
            }
            else{
                ans=Math.max(ans,temp);
                temp=1;
            }
        }
        return Math.max(ans,temp);
    }
}