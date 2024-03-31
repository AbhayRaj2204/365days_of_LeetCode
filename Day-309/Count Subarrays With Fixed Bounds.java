class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minP=-1,maxP=-1,donIdx=-1;
        for (int i=0;i<nums.length; i++){
            if(nums[i]<minK || nums[i] > maxK){
                donIdx=i;
            }
            if(nums[i]==minK){
                minP=i;
            }
            if(nums[i] == maxK){
                maxP=i;
            }
            int count = Math.min(minP, maxP)-donIdx;
            res +=(count >0)?count:0;
        }
        return res;
        
    }
}