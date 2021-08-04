/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
 var pathSum = function(root, targetSum) {
    return solve(root, targetSum, [], []);
};

function solve(root, sum, path, result) {
    if (!root) {
        return result;
    }

    path.push(root.val);

    if (!root.left && !root.right && root.val === sum) {
        result.push(path.slice());
    }

    solve(root.left, sum - root.val, path, result); 
    solve(root.right, sum - root.val, path, result);

    path.pop();

    return result;
}