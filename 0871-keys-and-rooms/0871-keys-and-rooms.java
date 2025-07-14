class Solution {
   public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] visited = new boolean[len];

        dfs(rooms, visited, 0);

        for (boolean vis:visited){
            if (!vis) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int idx){
        if (visited[idx]) return;
        visited[idx] = true;
        for (int num: rooms.get(idx)){
            dfs(rooms, visited, num);
        }

    }

}