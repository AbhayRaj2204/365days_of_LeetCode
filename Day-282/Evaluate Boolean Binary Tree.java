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
    public boolean evaluateTree(TreeNode root) {
         if(root.left == null && root.right == null){
            if(root.val == 1){
                return true;
            }else{
                return false;
            }
        }    

        boolean leftSide = evaluateTree(root.left);
        boolean rightSide = evaluateTree(root.right);

        if(root.val == 3){
            return leftSide && rightSide;
        }else{
            return leftSide || rightSide;
        }
    }
}