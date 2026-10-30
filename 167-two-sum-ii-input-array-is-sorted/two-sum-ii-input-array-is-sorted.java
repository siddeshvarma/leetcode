class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans=new int[]{-1,-1};
        int low=0;
        int high=numbers.length-1;
        while(low<high){
            if(numbers[low]+numbers[high]==target){
                ans[0]=low+1;
                ans[1]=high+1;
                return ans;
            }
            else if(numbers[low]+numbers[high]>target){
                high--;
            }
            else{
                low++;
            }
        }return ans;
    }
}