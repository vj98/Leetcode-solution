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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List <List <Integer>> ans =  new ArrayList<>();
        List <Integer> path = new ArrayList<>();
        
        solve(root, targetSum, ans, path);
        
        return ans;
    }
    
    public void solve(TreeNode root, int target, List <List <Integer>> ans, List <Integer> path) {
         if (root == null) {
            return;
        }
        
        path.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        
    
        solve(root.left, target-root.val, ans, path);
        solve(root.right, target-root.val, ans, path);
        path.remove(path.size()-1);
    }
}