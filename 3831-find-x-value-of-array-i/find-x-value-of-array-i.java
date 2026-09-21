// class Solution {
//     public int solve(int i, int j, int[] nums, int k) {
//         long product = 1;
//         for (int t = i; t <= j; t++) {
//             product = (product * nums[t]) % k;
//         }
//         return (int) product;
//     }

//     public long[] resultArray(int[] nums, int k) {
//         int n = nums.length;
//         long[] result = new long[k];

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int x = solve(i, j, nums, k);
//                 result[x]++;
//             }
//         }

//         return result;
//     }
// }
//S.C : O(k)
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        long[] result = new long[k];
        long[] prevCount = new long[k];

        for (int i = 0; i < n; i++) {

            //index i par end hone waale all subarrays
            long[] currCount = new long[k];

            int currElementRemainder = nums[i] % k;
            currCount[currElementRemainder]++;

            for (int oldRem = 0; oldRem <= k - 1; oldRem++) {
                int newRemain = (int) (((long) oldRem * nums[i] % k) % k);

                currCount[newRemain] += prevCount[oldRem];
            }

            prevCount = currCount;

            for (int x = 0; x <= k - 1; x++) {
                result[x] += prevCount[x];
            }
        }

        return result;
    }
}