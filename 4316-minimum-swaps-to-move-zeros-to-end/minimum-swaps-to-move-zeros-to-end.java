class Solution {
    public int minimumSwaps(int[] nums) {
        int tot=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)tot++;
        }
        int newTot=tot;
        for(int i=nums.length-tot;i<nums.length;i++){
            if(nums[i]==0){
                newTot--;
            }
        }
        return newTot;
    }
}