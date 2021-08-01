/**
 * @param {number[][]} grid
 * @return {number}
 */
 var largestIsland = function(grid) {
    let connectedGroupId = 2;
    let hash = {}; // groupid, connected count
    let ans = 0;
    
    var dfs = function(grid, i, j, id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = id;
        return dfs(grid, i - 1, j, id) + dfs(grid, i + 1, j, id) + dfs(grid, i, j - 1, id) + dfs(grid, i, j+1, id) + 1;
                // left + right + up + down + converting 0 to 1
    }

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 1) {
                let connectedCount = dfs(grid, i, j, connectedGroupId);
                hash[connectedGroupId] =  connectedCount;
                ans = Math.max(ans, connectedCount);
                connectedGroupId++;
            }
        }
    }
    

    let dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 0) {
                let temp = 1;
                let set = new Set();
                for (let k = 0; k < 4; k++) {
                    let row = i + dir[k][0];
                    let col = j + dir[k][1];

                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
                        continue;
                    }
                    set.add(grid[row][col]);  
                }

                for (let val of set) {
                    temp += hash[val];
                }
                ans = Math.max(ans, temp);
            }
        }
    }

    return ans;
};