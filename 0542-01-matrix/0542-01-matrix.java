class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distances = new int[mat.length][mat[0].length];
        
        int maxdist = mat.length + mat[0].length - 2;
        
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] != 0 ){
                    int upcell = (i > 0) ? distances[i-1][j] : maxdist;
                    int leftcell = (j > 0) ? distances[i][j-1] : maxdist;
                    distances[i][j] = Math.min(upcell, leftcell) + 1;
                }
            }
        }
        for (int i = mat.length-1; i >= 0; i--){
            for (int j = mat[0].length - 1; j >= 0; j--){
                if (mat[i][j] != 0){
                    int downcell = (i < mat.length-1) ? distances[i+1][j] : maxdist;
                    int rightcell = (j < mat[0].length - 1) ? distances[i][j+1] : maxdist;
                    distances[i][j] = Math.min((Math.min(downcell, rightcell) + 1), distances[i][j]);
                }
            }
        }
        return distances;
    }
}