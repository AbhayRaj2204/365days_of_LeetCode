class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res=0;
        for(int i=0, pv=0;i<s.length(); ++i) {
            if(s.charAt(i)=='(') stack.push(pv);
            else if(!stack.isEmpty()){
                res=Math.max(res, i - (pv=stack.pop()) + 1);
                continue;
            }
            pv=i+1;
        }
        return res;
    }
}