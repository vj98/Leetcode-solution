/**
 * @param {number[]} piles
 * @return {boolean}
 */
 var stoneGame = function(piles) {
    let n = piles.length;
    let dp = [...Array(n)].map(_ => Array(n).fill(-1));
    
    let solve = (i = 0, j = n - 1) => {
        if (i > j) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
      
        dp[i][j] = Math.max(piles[i] - solve(i + 1, j), piles[j] - solve(i, j - 1));
        return dp[i][j];
    };
    return solve() > 0;
};