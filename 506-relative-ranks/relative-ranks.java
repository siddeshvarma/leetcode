class Solution {
    public String[] findRelativeRanks(int[] score) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i : score) pq.offer(i);
        HashMap<Integer,String> map = new HashMap<>();
        int rank = 1;
        while(!pq.isEmpty()) {
            int num = pq.poll();
            if(rank == 1) map.put(num,"Gold Medal");
            else if(rank == 2) map.put(num,"Silver Medal");
            else if(rank == 3) map.put(num,"Bronze Medal");
            else map.put(num,String.valueOf(rank));
            rank++;
        }
        String[] ans = new String[score.length];
        for(int i = 0; i < score.length; i++) {
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}