class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1); 
        if (2*k + 1 > nums.length) return res;
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = k; i < nums.length - k; i++) {
            long sum = prefixSum[i + k] - prefixSum[i - k] + nums[i - k];
            res[i] = (int) (sum / (2 * k + 1));
        }

        return res;
    }
}