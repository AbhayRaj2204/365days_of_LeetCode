class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;

        for(int i=0;i<S.length(); i++){
            char ch=S.charAt(i);

            if(Character.isDigit(ch)){
                size = size * Integer.parseInt(""+ch);
            }
            else{
                size++;
            }
        }
        for(int i= S.length()-1; i>=0; i--){
            char ch = S.charAt(i);
            K = K%= size;

            if(K==0 && Character.isDigit(ch)==false){
                return ""+ch;
            }
            if(Character.isDigit(ch)){
                size = size/(Integer.parseInt(""+ch));
            } else{
                size--;
            }
        }
        return "";
        
    }
}