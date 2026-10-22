
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = check(nums);
        int ans = -1;
        if (k != -1) {
            ans = Math.min(k, n - k + 2);
        }
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = nums[n - 1 - i];
        }

        k = check(rev);

        if (k != -1) {
            int operations = Math.min(k + 1, n - k + 1);

            if (ans == -1 || operations < ans) {
                ans = operations;
            }
        }

        return ans;
    }

    public int check(int[] arr) {
        int n = arr.length;
        int k = 0;

        while (k < n && arr[k] != 0) {
            k++;
        }

        if (k == n) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[(k + i) % n] != i) {
                return -1;
            }
        }

        return k;
    }
}
