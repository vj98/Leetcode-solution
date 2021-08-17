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
     public int solve(TreeNode root, int v) {
        if (root == null) {
            return 0;
        }
        
        // maxvalue including current node
        int mx = Math.max(v, root.val);
        
        // comparing current node to the max value till the previous node
        return ((root.val >= v) ? 1 : 0) + solve(root.left, mx) + solve(root.right, mx);
    }
    
    public int goodNodes(TreeNode root) {
        return solve(root, root.val);
    }
}