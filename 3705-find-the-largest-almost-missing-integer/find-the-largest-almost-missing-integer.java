class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Count frequency of every element
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Case 1: k = 1
        if (k == 1) {
            int ans = -1;

            for (int x : nums) {
                if (freq.get(x) == 1) {
                    ans = Math.max(ans, x);
                }
            }

            return ans;
        }

        // Case 2: k = n
        if (k == n) {
            int ans = Integer.MIN_VALUE;

            for (int x : nums) {
                ans = Math.max(ans, x);
            }

            return ans;
        }

        // Case 3: 1 < k < n
        int ans = -1;

        // Check first element
        if (freq.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        // Check last element
        if (freq.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}