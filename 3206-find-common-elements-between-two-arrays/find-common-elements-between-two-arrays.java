class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer>st=new HashSet<>();
        HashSet<Integer>st1=new HashSet<>();
        for(int num:nums1){
            st.add(num);
        }
        for(int num:nums2){
            st1.add(num);
        }
        int count1=0;
        int count2=0;
        for(int num:nums1){
            if(st1.contains(num))count1++;
        }
        for(int num:nums2){
            if(st.contains(num))count2++;
        }
        return new int[]{count1,count2};
    }
}