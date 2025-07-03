class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, m = grid.length, n = grid[0].length, count = 0;

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    fresh++;
                } else if (grid[i][j] == 2){
                    queue.offer(i*n+j);
                } 
            }
        }

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

        while (!queue.isEmpty()){
            if (fresh == 0 ) return count;
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++){
                int pos = queue.poll();
                
                for (int[] dir: dirs){
                    int r = pos/n + dir[0], c = pos%n + dir[1];

                    if (r < 0 || c < 0 || r > m-1 || c > n-1) continue;

                    if (grid[r][c] == 1){
                        fresh--;
                        queue.offer(r*n+c);
                        grid[r][c] = 2;
                    }
                }

            }
        }

        return fresh != 0? -1 : count;
    }
}