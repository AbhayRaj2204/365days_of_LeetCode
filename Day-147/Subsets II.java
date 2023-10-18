class Solution {
    int[] tillFreq ;
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		tillFreq = new int[10];
		int[] numFreq = new int[21];
		for (int i = 0; i < nums.length; i++) {
			tillFreq[i] = ++numFreq[nums[i]+10];
		}
		numFreq = new int[21];
		List<List<Integer>> subSets = new ArrayList<>();
		backTrack2(nums, new ArrayList<>(), subSets, 0,numFreq);
		return subSets;
	}

	private void backTrack2(int[] nums, ArrayList<Integer> arrayList, List<List<Integer>> subSets, int l,int[] numFreq) {
		subSets.add(new ArrayList<>(arrayList));
		for (int i = l; i < nums.length; i++) {
			if ((tillFreq[i] - 1) != numFreq[nums[i]+10])
				continue;
			arrayList.add(nums[i]);
			numFreq[nums[i]+10]++;
			backTrack2(nums, arrayList, subSets, i + 1,numFreq);
			arrayList.remove(arrayList.size() - 1);
			numFreq[nums[i]+10]--;
		}
	}
}