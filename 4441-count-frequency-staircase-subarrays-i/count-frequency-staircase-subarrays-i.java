class Solution {
    public int countStaircase(int[] nums) {
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer>arr=new ArrayList<>();
            HashMap<Integer,Integer>mp=new HashMap<>();
            int cnt=0;
            arr.add(cnt);
            arr.set(cnt,arr.get(cnt)+1);
            mp.put(nums[i],cnt);
            cnt++;
            for(int j=i+1;j<nums.length;j++){
                if(!mp.containsKey(nums[j])){
                    mp.put(nums[j],cnt);
                    cnt++;
                    arr.add(0);
                }
                arr.set(mp.get(nums[j]),arr.get(mp.get(nums[j]))+1);
                boolean flag=false;
                for(int k=0;k<arr.size();k++){
                    if(arr.get(k)==(k+1)){
                        flag=true;
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
                if(flag)ans++;
            }
        }return ans;
    }
}