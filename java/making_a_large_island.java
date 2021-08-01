class Solution {
    public int largestIsland(int[][] grid) {
        int connectedGroupId = 2;
        HashMap <Integer, Integer> hash = new HashMap<>(); // groupid, connected count
        int ans = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int connectedCount = dfs(grid, i, j, connectedGroupId);
                    hash.put(connectedGroupId, connectedCount);
                    ans = Math.max(ans, connectedCount);
                    connectedGroupId++;
                }
            }
        }
        
        int [][]dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int temp = 1;
                    HashSet <Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int row = i + dir[k][0];
                        int col = j + dir[k][1];
                        
                        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
                            continue;
                        }
                        set.add(grid[row][col]);  
                    }
                    
                    for (int val: set) {
                        temp += hash.get(val);
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        
        return ans;
    }
    
    public int dfs(int [][]grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = id;
        return dfs(grid, i - 1, j, id) + dfs(grid, i + 1, j, id) + dfs(grid, i, j - 1, id) + dfs(grid, i, j+1, id) + 1;
                // left + right + up + down + converting 0 to 1
    }
}