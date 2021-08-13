class Solution {
    public void setZeroes(int[][] matrix) {
        Boolean firstCol = false, firstRow = false;
        
        for (int i = 0; i < matrix.length; i++) { //check the first column
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            } 
        }
        
        for (int i = 0; i < matrix[0].length; i++) { //check the first row
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            } 
        }
        
        for (int i = 1; i < matrix.length; i++) { //check except the first row and column
            for (int j = 1; j < matrix[0].length; j++) 
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        
        for (int i = 1; i < matrix.length; i++) { //process except the first row and column
           for (int j = 1; j < matrix[0].length; j++) 
               if (matrix[i][0] == 0 || matrix[0][j] == 0)
                   matrix[i][j] = 0;
        }
        
        if (firstCol) { // first column zeros
            for (int i = 0; i < matrix.length; i++) 
                matrix[i][0] = 0;
        }
        
        if (firstRow) { // first row zeros
            for (int i = 0; i < matrix[0].length; i++) 
                matrix[0][i] = 0;
        }
    }
}