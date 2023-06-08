class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        
        for(int[] a : grid) {
            result += findNegative(a);
        }
        return result;
    }
    public int findNegative(int[] a){
        if(a[0] < 0) return a.length;

        if(a[a.length - 1] >= 0) return 0;

        int start = 0;
        int end = a.length - 1;
        int index = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(a[mid] < 0){
                index = mid;
                end = mid -1;

            }
            else{
                start = mid + 1;
            }
        }
        return a.length - index;
    }
}