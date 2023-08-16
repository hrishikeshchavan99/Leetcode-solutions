class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        boolean[] visited = new boolean[n+1];
        int res = 0;
        for (int[] time: times){
            map.putIfAbsent(time[0], new HashMap());
            map.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> (a[0]-b[0]));
        q.offer(new int[]{0, k});

        while (!q.isEmpty()){
            int[] node = q.poll();
            int curDist = node[0];
            int curNode = node[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            n--;
            res = curDist;
            if (map.containsKey(curNode)){
                for (int next: map.get(curNode).keySet()){
                    q.offer(new int[]{curDist+map.get(curNode).get(next), next});
                }
            }
        }
        return n == 0? res: -1;
    }
}