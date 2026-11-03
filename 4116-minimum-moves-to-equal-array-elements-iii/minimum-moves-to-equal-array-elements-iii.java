class Solution {
    public int minMoves(int[] nums) {
        int maxNum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxNum=Math.max(maxNum,nums[i]);
        }
        int right=0;
        for(int i=0;i<nums.length;i++){
            right=right+Math.abs(nums[i]-maxNum);
        }
        return right;
    }
}