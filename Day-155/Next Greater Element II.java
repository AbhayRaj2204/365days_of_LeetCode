class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=max){
                max=nums[i];
                j=i;
            }
        }
        int[] ar=new int[nums.length];
        int c=0;
        for(int i=j+1;i<nums.length;i++){
            ar[i-j-1]=nums[i];
            c++;
        }
        for(int i=0;i<=j;i++){
           ar[c]=nums[i];
            c++;
        }
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums.length];
        ans[nums.length-1]=-1;
        st.push(ar[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=ar[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
                st.push(ar[i]);
            }
            else{
            ans[i]=st.peek();
            st.push(ar[i]);
        }}
         c=0;
        for(int i=nums.length-j-1;i<nums.length;i++){
            ar[c]=ans[i];
            c++;
        }
        j=0;
        for(int i=c;i<nums.length;i++){
           ar[i]=ans[j];
           j++;
        }

        return ar;
     }
}