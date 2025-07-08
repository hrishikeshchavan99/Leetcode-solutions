class Solution {
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList();
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //1st row & 1st col will always flow to pacific
        //last row & last col will always flow to atlantic
        //so start dfs from these row/col and update visited pacific/atlantic
        //if part of both visited arrays, add to result
        for (int i = 0; i < m; i++){
            dfs(i, 0, pacific, heights, Integer.MIN_VALUE); 
            dfs(i, n-1, atlantic, heights, Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++){
            dfs(0, j, pacific, heights, Integer.MIN_VALUE);
            dfs(m-1, j, atlantic, heights, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    private void dfs(int row, int col, boolean[][] visited, int[][] heights, int prev){
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || heights[row][col] < prev) return;

        visited[row][col] = true;
        dfs(row+1, col, visited, heights, heights[row][col]);
        dfs(row, col+1, visited, heights, heights[row][col]);
        dfs(row-1, col, visited, heights, heights[row][col]);
        dfs(row, col-1, visited, heights, heights[row][col]);
        

    }
}