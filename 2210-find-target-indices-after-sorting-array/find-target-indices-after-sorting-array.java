class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer>ans=new ArrayList<>();
        int tot=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)tot++;
            if(nums[i]<target)cnt++;
        }
        for(int i=0;i<tot;i++){
            ans.add(cnt);
            cnt++;
        }return ans;
    }
}