class Solution {
    public int longestSubarray(int[] nums) {
        // int i=0;
        // int j=0;
        // int cnt=1;
        // int ans=Integer.MIN_VALUE;
        // int temp=0;
        // while(j<nums.length){
        //     if(nums[j]==1){
        //         temp++;
        //     }
        //     else{
        //         if(cnt!=0){             
        //             cnt--;
        //         }
        //         else{
        //             ans=Math.max(ans,temp);
        //             temp=j-i-1;
        //             i=j;
        //         }
        //     }
        //     ans=Math.max(ans,temp);
        //     j++;
        // }
        // if(temp==nums.length)return nums.length-1;
        // return Math.max(ans,(j-i)-1);
        int i = 0;
        int j = 0;
        int cnt = 0;
        int ans = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                cnt++;
            }
            while (cnt > 1) {
                if (nums[i] == 0) {
                    cnt--;
                }
                i++;
            }

            ans = Math.max(ans, j - i);
            j++;
        }

        return ans;
    }
}