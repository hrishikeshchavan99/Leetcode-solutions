class Solution {

    public int maxTotalReward(int[] rewardV) {
        int n = rewardV.length;
        Arrays.sort(rewardV);

        int[][] dp = new int[n][4000];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return backtrack(rewardV, 0, 0, dp);
        
    }
    
    public int backtrack(int[] arr, int i, int cur, int[][] dp){
        if (i >= arr.length) return 0;
        if (dp[i][cur] > -1) return dp[i][cur];
        int max = -1;
        if (arr[i] > cur){
            max = arr[i] + backtrack(arr, i+1, cur+arr[i], dp);
        }
        
        max = Math.max(max, backtrack(arr, i+1, cur, dp));

        dp[i][cur] = max;

        return max;
    };
}