class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int[] ans = new int[k];

        for(int i = 0; i < nums.length; i++)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);

        int[][] arr = new int[hm.size()][2];
        int i = 0;

        for(Integer x : hm.keySet()){
            arr[i][0] = x;
            arr[i][1] = hm.get(x);
            i++;
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return Integer.compare(a[1], b[1]);
            }
        });

        i = 0;

        for(int j = arr.length-1; j >= 0 && i < k; j--, i++)
            ans[i] = arr[j][0];
    
        return ans;
    }
}
// UP-VOTE IF HELPFUL