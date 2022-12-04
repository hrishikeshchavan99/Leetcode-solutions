class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        Queue <Integer> queue = new LinkedList();
        int fresh = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) queue.add(i * n + j);
            }    
        }
        int[][] directions = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for (int k = 0; k < size; k++){
                int rotten = queue.poll();
                int i = rotten / n;
                int j = rotten % n;
                for (int[] direction: directions){
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1){
                        queue.add(x * n + y);
                        fresh--;
                        grid[x][y] = 2;
                        
                    }
                }
            }
            count++;
        }
        return fresh == 0 ? count : -1;
    }
    
}