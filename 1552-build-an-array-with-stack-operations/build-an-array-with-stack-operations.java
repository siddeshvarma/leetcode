class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i=1;
        int j=0;
        List<String>ans=new ArrayList<>();
        while(i<=n && j<target.length){
            if(i==target[j]){
                ans.add("Push");
                i++;
                j++;
            }
            else if(i<target[j]){
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
        }return ans;
    }
}