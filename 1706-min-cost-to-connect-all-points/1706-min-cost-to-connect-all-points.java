class Solution {
    //Prims algorithm
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int next = 0, sum = 0;
        visited[0] = true;
        
        for (int i = 0; i < n; i++){
            dist[i] = findDist(points, 0, i);
        }
        while (true){
            next = -1;
            for (int i = 0; i < n; i++){
                if (visited[i]) continue;
                if (next == -1 || dist[i] < dist[next]) next = i; 
            }
            if (next == -1) break;
            sum += dist[next];
            visited[next] = true;
            for (int i = 0; i < n; i++){
                if (!visited[i])
                    dist[i] = Math.min(findDist(points, next, i), dist[i]);
            }
        }
        return sum;
    }
    private int findDist(int[][] points, int a, int b){
        return Math.abs(points[a][0]-points[b][0]) + Math.abs(points[a][1]-points[b][1]);
    }
}
