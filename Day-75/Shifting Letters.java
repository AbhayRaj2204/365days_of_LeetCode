class Solution {
    public String shiftingLetters(String s, int[] shifts) {        
        char arr[]=s.toCharArray();
        int total_shifts=0;
        int i = s.length() -1;
        while(i>=0){
            total_shifts += shifts[i]%26;
            arr[i]=(char)((arr[i] - 'a' + total_shifts)%26 + 'a');
            i--;
        }
        return String.valueOf(arr);
    }
}