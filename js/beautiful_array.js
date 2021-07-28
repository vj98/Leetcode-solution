/**
 * @param {number} n
 * @return {number[]}
 */
 var beautifulArray = function(n) {
    let ans = [];
    
    ans.push(1);
    while (ans.length < n) {
        let temp = [];
        
        // odd 
        for (let i = 0; i < ans.length; i++) {
            if (ans[i] * 2 - 1  <= n) {
                temp.push(ans[i] * 2 - 1);
            }
        }
        
        // even
        for (let i = 0; i < ans.length; i++) {
            if (ans[i] * 2 <= n) {
                temp.push(ans[i] * 2);
            }
        }
        
        ans = temp;
    }
    
    return ans;
};