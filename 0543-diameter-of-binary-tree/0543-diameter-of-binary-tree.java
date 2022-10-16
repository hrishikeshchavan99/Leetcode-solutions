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
    private int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return longestPath;
    }
    private int height(TreeNode node){
        if (node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        
        longestPath = Math.max(longestPath, lheight+rheight);
        return Math.max(lheight, rheight) + 1;
    }
}