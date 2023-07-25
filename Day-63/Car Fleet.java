class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Step 1
        float[] moves = new float[position.length];
        
        for(int i=0; i<position.length;i++){
            moves[i] = (((float)target - position[i]) / speed[i] );
        }    
        
        // Step 2
        int fleet = 0;
        int counter =0;
        int maxPosition = -1, maxIndex = -1;
        float maxPositionMoves;
        
        while(counter < position.length){
            
            // Step 2a
            fleet++;
            maxPosition = -1; maxIndex = -1;
            
            for(int j=0; j<position.length;j++){

                if(position[j] > maxPosition) {
                    maxPosition = position[j];
                    maxIndex = j;
                }
            }
            
            // Step 2b
            maxPositionMoves = moves[maxIndex];
            
            for(int k=0; k<moves.length; k++){
                
                if(moves[k] !=0 && moves[k] <= maxPositionMoves){
                    moves[k] = 0;
                    position[k] = -1;
                    counter++;                
                }    
            }
        }
        return fleet;    
    }
}