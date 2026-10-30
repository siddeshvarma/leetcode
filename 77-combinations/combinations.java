class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;//[1,2,3,4]
        }
        possible(ans,arr,k,0,temp);
        return ans;
    }
    public void possible(List<List<Integer>>ans,int[] arr,int k,int index,List<Integer>temp){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index>=arr.length)return;
        temp.add(arr[index]);
        possible(ans,arr,k,index+1,temp);
        temp.removeLast();
        possible(ans,arr,k,index+1,temp);
    }
}