/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[][]}
 */
 var levelOrder = function(root) {
    if (root == null) {
        return [];
    }
    
    let queue = [];
    queue.push({level: 0, node: root});
    
    let result = [];
    
    while(queue.length > 0) {
        let curr = queue.shift();
        let level = curr.level;
        
        if (result[level] == null) {
            result[level] = [];
        }
        result[level].push(curr.node.val);
        
        for(let child of curr.node.children) {
            queue.push({level: level + 1, node: child});
        }
    }
    return result;
};