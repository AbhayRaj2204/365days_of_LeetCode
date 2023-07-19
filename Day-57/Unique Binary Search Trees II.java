/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp=new ArrayList[n+1][n+1];
        return memo(1,n,dp);
    }
    List<TreeNode> memo(int s,int e,List<TreeNode>[][] dp){
        if(s>e){
            List<TreeNode> a=new ArrayList<>();
            a.add(null);
            return a;
        }
        if(dp[s][e]!=null) return dp[s][e];
        dp[s][e]=new ArrayList<>();
        for(int i=s;i<=e;i++){
            List<TreeNode> left=memo(s,i-1,dp);
            List<TreeNode> right=memo(i+1,e,dp);
            for(TreeNode l:left)
                for(TreeNode r:right)
                    dp[s][e].add(new TreeNode(i,l,r));
        }
        return dp[s][e];
    }
}