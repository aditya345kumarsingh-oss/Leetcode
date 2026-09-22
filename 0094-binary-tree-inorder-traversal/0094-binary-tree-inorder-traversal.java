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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        inorder(root, ans);

        return ans;
    }


    public void inorder(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left, ans);

        // Root
        ans.add(root.val);

        // Right
        inorder(root.right, ans);

        
    }
}