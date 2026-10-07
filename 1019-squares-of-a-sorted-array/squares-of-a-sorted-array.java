class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int[] ans=new int[nums.length];
        int k=0;
        while(i<=j){
            if(Math.pow(nums[i],2)>=Math.pow(nums[j],2)){
                ans[k]=nums[i]*nums[i];
                i++;
            }
            else{
                ans[k]=nums[j]*nums[j];
                j--;
            }
            k++;
        }
        i=0;j=nums.length-1;
        while(i<=j){
            int temp=ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
            i++;j--;
        }
        return ans;
    }
}