class Solution {
    public int thirdMax(int[] nums) {
        int u =nums.length-1;
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            for(int j=1+i;j<nums.length;j++){
                if(nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int max = nums[0];
        if(nums.length > 2){
            for(int i=0; i<nums.length; i++){
                if(nums[i] < max && count <2 && i != 0 && nums[i] != max){
                    max = nums[i];
                    count++;
                }
            }       
        }

        if(count == 2){
                return max;
            }
                return nums[0];
    }
}