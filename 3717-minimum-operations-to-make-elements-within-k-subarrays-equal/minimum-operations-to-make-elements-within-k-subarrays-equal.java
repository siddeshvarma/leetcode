class Solution {
    public long minOperations(int[] nums, int x, int k) {
         int n = nums.length;
        int numWindows = n - x + 1;
        long[] arr = new long[numWindows];
        
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();
        long lowerSum = 0, upperSum = 0;
        int lowerSize = 0, upperSize = 0;
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (lowerSize == 0 || nums[i] <= lower.lastKey()) {
                lower.put(nums[i], lower.getOrDefault(nums[i], 0) + 1);
                lowerSum += nums[i];
                lowerSize++;
            } else {
                upper.put(nums[i], upper.getOrDefault(nums[i], 0) + 1);
                upperSum += nums[i];
                upperSize++;
            }
            
            if (i >= x) {
                int outNum = nums[i - x];
                if (lower.containsKey(outNum)) {
                    int count = lower.get(outNum);
                    if (count == 1) {
                        lower.remove(outNum);
                    } else {
                        lower.put(outNum, count - 1);
                    }
                    lowerSum -= outNum;
                    lowerSize--;
                } else if (upper.containsKey(outNum)) {
                    int count = upper.get(outNum);
                    if (count == 1) {
                        upper.remove(outNum);
                    } else {
                        upper.put(outNum, count - 1);
                    }
                    upperSum -= outNum;
                    upperSize--;
                }
            }
            
            if (lowerSize < upperSize) {
                int val = upper.firstKey();
                int count = upper.get(val);
                if (count == 1) {
                    upper.remove(val);
                } else {
                    upper.put(val, count - 1);
                }
                upperSum -= val;
                upperSize--;
                
                lower.put(val, lower.getOrDefault(val, 0) + 1);
                lowerSum += val;
                lowerSize++;
            } else if (lowerSize - upperSize > 1) {
                int val = lower.lastKey();
                int count = lower.get(val);
                if (count == 1) {
                    lower.remove(val);
                } else {
                    lower.put(val, count - 1);
                }
                lowerSum -= val;
                lowerSize--;
                
                upper.put(val, upper.getOrDefault(val, 0) + 1);
                upperSum += val;
                upperSize++;
            }
            
            if (i >= x - 1) {
                int median = lower.lastKey();
                arr[idx++] = ((long) median * lowerSize - lowerSum) + (upperSum - (long) median * upperSize);
            }
        }
        
        Long[][] memo = new Long[numWindows + 1][k + 1];
        long result = dp(0, k, x, arr, memo);
        
        return result >= Long.MAX_VALUE / 2 ? -1 : result;
    }
    
    private long dp(int index, int remK, int x, long[] arr, Long[][] memo) {
        if (remK == 0) return 0;
        if (index >= arr.length) return Long.MAX_VALUE / 2;
        
        if (memo[index][remK] != null) {
            return memo[index][remK];
        }
        
        long skip = dp(index + 1, remK, x, arr, memo);
        long take = arr[index] + dp(index + x, remK - 1, x, arr, memo);
        
        return memo[index][remK] = Math.min(skip, take);
    }
}