class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; // row length
        int n = mat[0].length; // column length
        
        Queue<int[]> queue = new LinkedList<>(); // storing 0 value index
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int level = 0;
        while (!queue.isEmpty()) {
            // rowColIndex[0] --> row index
            // rowColIndex[1] --> col index
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rowColIndex = queue.poll();
                for (int[] d : dirs) {
                    int row = rowColIndex[0] + d[0];
                    int col = rowColIndex[1] + d[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || mat[row][col] != Integer.MAX_VALUE){
                        continue;
                    }
                    queue.add(new int[] {row, col});
                    mat[row][col] = level;
                }
            }
        }
        
        return mat;
    }
}