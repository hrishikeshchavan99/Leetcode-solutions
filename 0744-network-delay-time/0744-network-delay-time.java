class Solution {
    //BFS/ Dijkastra's Alogorithm- https://www.youtube.com/watch?v=V6H1qAeB-l4
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        boolean[] visited = new boolean[n+1];
        int res = 0;
        //Put all data in hashmap
        for (int[] time: times){
            map.putIfAbsent(time[0], new HashMap());
            map.get(time[0]).put(time[1], time[2]);
        }

        //priority queue sorted by dist
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> (a[0]-b[0]));
        q.offer(new int[]{0, k}); // start with node k

        while (!q.isEmpty()){
            int[] node = q.poll();
            int curDist = node[0];
            int curNode = node[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            n--; //when n becomes 0, all nodes are visited
            res = curDist; //distance travelled to reach that node. if that node is last one, we got the answer
            if (map.containsKey(curNode)){
                //get all nodes connected to curNode and put into queue
                for (int next: map.get(curNode).keySet()){
                    q.offer(new int[]{curDist+map.get(curNode).get(next), next});
                }
            }
        }
        return n == 0? res: -1;
    }
}