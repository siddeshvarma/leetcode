class Solution {
    public int minDay(int[] bloomDay){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(min>bloomDay[i]){
                min=bloomDay[i];
            }
        }
        return min;
    }

    public int maxDay(int[] bloomDay){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(max<bloomDay[i]){
                max=bloomDay[i];
            }
        }
        return max;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low=minDay(bloomDay);
        int high=maxDay(bloomDay);
        int minDa=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean flag=bloom(bloomDay,mid,m,k);
            if(flag){
                minDa=Math.min(minDa,mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }return minDa==Integer.MAX_VALUE?-1:minDa;
    }

    public boolean bloom(int[] bloomDay,int mid,int m, int k){
        int cnt=0;
        int totalCnt=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                cnt++;
            }
            else{
                cnt=0;
            }
            if(cnt==k){
                totalCnt++;
                cnt=0;
            }
        } return totalCnt>=m;
    }
}