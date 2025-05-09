class Solution {
    public void setZeroes(int[][] matrix) {
        //use first row and column as a memory to keep track of all the 0's in the entire matrix
        //col0 is used to keep track 0 in first col, 
        //if it is not done it will make mat[0][0] 0 making entire first row 0
        //So handle it separately
        
        int m = matrix.length, n = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 1; j--){
                if (matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j] = 0;
                }
                
            }
            if (col0 == 0) matrix[i][0] = 0;
            
        }

    }
}