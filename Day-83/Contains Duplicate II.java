class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, Integer> cache = new HashMap<>();
      int length = nums.length;
      for (int i = 0; i < length; i++) {
        Integer prev = cache.put(nums[i], i);
        if (prev != null && i - prev <= k) {
          return true;
        }
      }
    return false;
  }
}