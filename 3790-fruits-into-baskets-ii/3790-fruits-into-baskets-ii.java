class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt = 0;
        boolean[] visited = new boolean[fruits.length];

        for (int i = 0; i < fruits.length; i++){
            boolean found = false;
            for (int j = 0; j < baskets.length; j++){
                if (!visited[j] && baskets[j] >= fruits[i]){
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) cnt++;
        }
        
        return cnt;
    }
}