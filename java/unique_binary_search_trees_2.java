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
    
    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) {
          ans.add(null);
          return ans;
        }

        for (int i = start; i <= end; i++) {
          List<TreeNode> leftTrees = solve(start, i - 1);

          List<TreeNode> rightTrees = solve(i + 1, end);

          for (TreeNode l : leftTrees) {
            for (TreeNode r : rightTrees) {
              TreeNode currentTree = new TreeNode(i);
              currentTree.left = l;
              currentTree.right = r;
              ans.add(currentTree); // contains all trees
            }
          }
        }
        return ans;
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
          return new ArrayList<TreeNode>();
        }
        return solve(1, n);
    }
}