// class Solution {
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) {
//         int i=0;
//         int j=0;
//         int ans=Integer.MAX_VALUE;
//         int sum=0;
//         while(j<nums.size()){
//             sum=sum+nums.get(j);
//             if((j-i+1)>=l && (j-i+1)<=r){
//                 if(sum>0)
//                 ans=Math.min(ans,sum);
//                 else
//                 sum=0;
//             }
//             else{
//                while((j-r+1)>r){
//                 sum=sum-nums.get(i);
//                 i--;
//                }
//             }
//             j++;
//         }
//         if(sum>0)
//             ans=Math.min(ans,sum);
//         if (ans==Integer.MAX_VALUE) return -1;
//         return ans;
//     }
// }

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int len = j - i + 1;

                if (len > r) break;

                if (len >= l && sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}