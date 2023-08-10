class Solution {
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         res.add(new ArrayList<>());

         for(int i : nums){
         int n = res.size();
             for(int j = 0; j < n; j++){
                 List<Integer> ans = new ArrayList<>(res.get(j));
                 ans.add(i);
                 res.add(ans);
             }
         }
         return res;
     }
}