class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //sort desc and pick last k points
        PriorityQueue<int[]> q = new PriorityQueue<>((p1,p2)->(p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]));
        for (int[] point: points){
            q.offer(point);
            if (q.size() > k){
                q.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++){
            res[i] = q.poll();
        }
        return res;
    }
}
//alt
/*
    sort asc and pick first k points
    Arrays.sort(points, (p1,p2)->(p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
    return Arrays.copyOfRange(points, 0, k);
 */