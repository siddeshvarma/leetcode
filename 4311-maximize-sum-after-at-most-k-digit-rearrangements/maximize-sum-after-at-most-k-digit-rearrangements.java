class Solution {
    public long maximizeSum(int[] nums, int k) {
        // TreeMap<Integer,Integer>mp=new TreeMap<>(Collections.reverseOrder());
        // for(int i=0;i<nums.length;i++){
        //     String str=String.valueOf(nums[i]);
        //     int[] arr=new int[str.length()];
        //     for(int j=0;j<arr.length;j++){
        //         arr[j]=str.charAt(j)-'0';
        //     }
        //     Arrays.sort(arr);
        //     for (int j = 0; j < arr.length / 2; j++) {
        //         int temp = arr[j];
        //         arr[j] = arr[arr.length - 1 - j];
        //         arr[arr.length - 1 - j] = temp;
        //     }
        //     int num=0;
        //     for (int k1 = 0; k1 < arr.length; k1++) {
        //         num = num * 10 + arr[k1];
        //     }
        //     mp.put(num,i);
        // }
        // long ans=0;
        // int cnt=0;
        // for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
        //     if(cnt==k){
        //         break;
        //     }
        //     if(entry.getKey()==nums[entry.getValue()]){
        //         continue;
        //     }
        //     cnt++;
        //     nums[entry.getValue()]=0;
        //     ans+=entry.getKey();
        // }
        // for(int i=0;i<nums.length;i++){
        //     ans=ans+nums[i];
        // }
        // return ans;

        ArrayList<Integer>arr2=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String str=String.valueOf(nums[i]);
            int[] arr=new int[str.length()];
            for(int j=0;j<arr.length;j++){
                arr[j]=str.charAt(j)-'0';
            }
            Arrays.sort(arr);
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[j];
                arr[j] = arr[arr.length - 1 - j];
                arr[arr.length - 1 - j] = temp;
            }
            int num=0;
            for (int k1 = 0; k1 < arr.length; k1++) {
                num = num * 10 + arr[k1];
            }
            arr2.add(num-nums[i]);
        }
        Collections.sort(arr2,Collections.reverseOrder());
        long ans=0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
        }
        for (int i = 0; i < k; i++) {
            ans += arr2.get(i);
        }
        return ans;
        }
}