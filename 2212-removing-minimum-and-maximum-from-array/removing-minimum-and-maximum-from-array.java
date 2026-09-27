class Solution {
    public int minimumDeletions(int[] nums) {

        int maxIdx = 0;
        int minIdx = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[maxIdx])
                maxIdx = i;

            if(nums[i] < nums[minIdx])
                minIdx = i;
        }

        int ans = Integer.MAX_VALUE;

        // Remove both from left
        ans = Math.min(ans, Math.max(maxIdx, minIdx) + 1);

        // Remove both from right
        ans = Math.min(ans, n - Math.min(maxIdx, minIdx));

        // Remove max from left and min from right
        ans = Math.min(ans, (maxIdx + 1) + (n - minIdx));

        // Remove min from left and max from right
        ans = Math.min(ans, (minIdx + 1) + (n - maxIdx));

        return ans;
    }
}