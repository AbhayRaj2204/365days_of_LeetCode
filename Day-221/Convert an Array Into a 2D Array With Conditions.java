class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<int[]> rows = new ArrayList<>();
        for(int n :nums){
            boolean added = false;
            for(int[]row : rows){
                if(row[n]== 1){
                    continue;
                }
                row[n] = 1;
                added = true;
                break;
            }
            if(!added){
                int[] newRow = new int[201];
                newRow[n] = 1;
                rows.add(newRow);
            }
        }
        List<List<Integer>>result = new ArrayList<>();
        for(int[] row : rows){
            List<Integer> resultRow = new ArrayList<>();
            for(int i = 0; i<= 200; i++){
                if(row[i] == 1){
                    resultRow.add(i);
                }
            }
            result.add(resultRow);
        }
        return result;
    }
}