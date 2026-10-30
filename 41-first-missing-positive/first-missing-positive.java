class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];

        for(int i = 0; i < nums.length; i++) {

            int x = nums[i];

            if(x > 0 && x <= n) {
                arr[x] = 1;
            }
        }

        for(int i = 1; i <= n + 1; i++) {

            if(arr[i] == 1) continue;
            else return i;
        }

        return n + 1;
    }
}