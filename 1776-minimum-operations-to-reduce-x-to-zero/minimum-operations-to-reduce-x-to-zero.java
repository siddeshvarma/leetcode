class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];//total sum of array
        }
        int i=0,j=0;
        int maxLength=Integer.MIN_VALUE;//this will find maximum subarray;
        int remSum=totalSum-x;
        int sum=0;
        while(j<nums.length){
            sum=sum+nums[j];
            j++;
            while(sum>remSum && i<j){
                sum=sum-nums[i];
                i++;
            }
            if(sum==remSum){
                maxLength=Math.max(maxLength,(j-i));
            }
        }
        if(maxLength== Integer.MIN_VALUE)return -1;
        return nums.length-maxLength;
    }
}