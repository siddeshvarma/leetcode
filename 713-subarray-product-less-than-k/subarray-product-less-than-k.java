class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
         if (k <= 1) {
            return 0;
        }

        int ans=0;
        int product=1;
        int j=0;
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            while(product>=k){
                product/=nums[j];
                j++;
            }
            ans=ans+(i-j+1);
        }
        return ans;
    }
}