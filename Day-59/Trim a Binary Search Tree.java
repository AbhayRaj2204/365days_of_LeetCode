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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean found = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (low <= curr.val && curr.val <= high) {
                root = curr;
                found = true;
                break;
            } else {
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        if (!found) return low <= root.val && root.val <= high ? root : null;
        trimBSTDFS(root, low, high);
        return root;
    }

    private void trimBSTDFS(TreeNode node, int low, int high) {
        if (node == null) return;

        while (node.left != null && node.left.val < low) node.left = node.left.right;
        while (node.right != null && node.right.val > high) node.right = node.right.left;
        trimBSTDFS(node.left, low, high);
        trimBSTDFS(node.right, low, high);
    }
}