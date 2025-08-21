/*class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, 0);
    }
    public int coinChange(int[] coins, int amount, int idx) {
        if (amount == 0){
            return 0;
        }
    
        int m1 = , m2 = Integer.MAX_VALUE;
        if (idx + 1 < coins.length)
            m1 = coinChange(coins, amount, idx+1);
        
        if (amount >= coins[idx] && idx < coins.length)
            m2 = 1 + coinChange(coins, amount-coins[idx], idx);

        return Math.min(m1, m2);
    }
}*/

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