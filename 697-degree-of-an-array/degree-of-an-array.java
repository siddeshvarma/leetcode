// class Solution {
//     public int findShortestSubArray(int[] nums) {
//         HashMap<Integer,Integer>mp=new HashMap<>();
//         int maxNum=0;
//         for(int i=0;i<nums.length;i++){
//             mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
//             if(mp.get(nums[i])>maxNum){
//                 maxNum=mp.get(nums[i]);
//             }
//         }
//         int ans=Integer.MAX_VALUE;
//         for (int k=0;k<nums.length;k++) {
//         int key = nums[k];
//         int value = mp.get(nums[k]);
//         int j=0;
//         int i=0;
//         if(value==maxNum){
//             int count=0;        
//             for(i=0;i<nums.length;i++){
//                 if(count==0 && nums[i]==key){
//                     j=i;
//                 }
//                 if(key==nums[i])count++;
//                 if(count==value)break;
//             }
//             int diff=i-j+1;
//             ans=Math.min(ans,diff);
//         }        
//         }
//         return ans;  
//     }
// }
class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            // First occurrence
            if (!first.containsKey(x)) {
                first.put(x, i);
            }

            // Frequency
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            // Last occurrence
            last.put(x, i);

            degree = Math.max(degree, freq.get(x));
        }

        int ans = Integer.MAX_VALUE;

        for (int x : freq.keySet()) {

            if (freq.get(x) == degree) {

                int length = last.get(x) - first.get(x) + 1;

                ans = Math.min(ans, length);
            }
        }

        return ans;
    }
}