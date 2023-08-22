class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
          
          if(str2.length()>str1.length()) return false;
           
          int i =0,j=0;
        
          while(i<str1.length())
          {
              
             char ch = str1.charAt(i);
             char ch2 =str2.charAt(j);
             
              if(ch=='z' && ch2=='a') j++;
            
              else if(ch2-ch==1 || ch2-ch==0){ 
                 j++;
              }
              
              if(j==str2.length()) return  true;
                i++;
          
          }
                return false;

    }
}