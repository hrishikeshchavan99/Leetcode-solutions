class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length];
        for (int i = 0; i <= amount; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int res = coinChange(coins, amount, 0, dp);
        return res >= 100_000 ? -1: res;
    }
    public int coinChange(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0){
            return 0;
        }
        if (dp[amount][idx] != -1 ) return dp[amount][idx];
    
        int m1 = 100_000, m2 = 100_000;
        if (idx + 1 < coins.length)
            m1 = coinChange(coins, amount, idx+1, dp);
        
        if (amount >= coins[idx] && idx < coins.length)
            m2 = 1 + coinChange(coins, amount-coins[idx], idx, dp);

        return dp[amount][idx] = Math.min(m1, m2);
    }
}
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
                    
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }
}
*/