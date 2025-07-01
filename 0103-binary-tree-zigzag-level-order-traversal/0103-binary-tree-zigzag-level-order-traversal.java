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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> temp = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        boolean dir = false;

        if (root == null) return res;

        queue.offer(root);
        temp.add(root.val);

        while (!queue.isEmpty()){
            dir = !dir;
            int n = queue.size();
            res.add(new ArrayList(temp));
            temp.clear();

            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    if (dir){
                        temp.add(0, node.left.val);
                    } else {
                        temp.add(node.left.val);
                    }
                    queue.offer(node.left);
                }
                if (node.right != null){
                    if (dir){
                        temp.add(0, node.right.val);
                    } else {
                        temp.add(node.right.val);
                    }
                    queue.offer(node.right);
                }
            }
        }

        return res;
    }
}