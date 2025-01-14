class Solution {
    int count = 0;
    int mod = 1_000_000_007;
    int dp[][][];
    public int countPathsWithXorValue(int[][] grid, int k) {
        dp = new int[grid.length][grid[0].length][16];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return navigate(grid, k, 0, 0, 0)%mod;
    }
    private int navigate(int[][] grid, int k, int i, int j, int xor){
        if (i >= grid.length || j >= grid[0].length){
            return 0;
        }

        xor = xor ^ grid[i][j];

        if (dp[i][j][xor] != -1) return dp[i][j][xor];

        if (i == grid.length-1 && j == grid[0].length-1){
            return xor == k ? 1: 0;
        }

        int right = navigate(grid, k, i+1, j, xor)%mod;
        int down = navigate(grid, k, i, j+1, xor)%mod;

        dp[i][j][xor] = right + down;
        
        return dp[i][j][xor];

    }
}