/*class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        return change(dp, amount, coins, 0);
    }
    public int change(int[][] dp, int amount, int[] coins, int idx){
        if (amount == 0){
            return 1;
        }
        
        if (idx >= coins.length || amount < 0) return 0;

        if (dp[amount][idx] != 0) return dp[amount][idx];
        int res = change(dp, amount, coins, idx+1);

        res += change(dp, amount-coins[idx], coins, idx);
        return dp[amount][idx] = res;
    }
}*/

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for (int j = 0; j < coins.length; j++){
            for (int i = 1; i <= amount; i++){
                if (i- coins[j] >= 0){
                    dp[i] += dp[i-coins[j]];
                }
            }
        }
        return dp[amount];
    }
}


/**
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount][coins.length];
        for (int i = 0; i < coins.length; i++) Arrays.fill(dp[i], -1);
        return count(coins, amount, 0, 0, dp);
    }
    private int count(int[] coins, int amt, int cur, int idx, int[][] dp){
        if (amt == cur){
            System.out.println("amt");
            return 1;
        } 
        if (cur > amt || idx >= coins.length) return 0;
        //if (dp[cur][idx] >= 0) return dp[cur][idx];
        int cnt1 = count(coins, amt, cur+coins[idx], idx, dp);
        int cnt2 = count(coins, amt, cur, idx+1, dp);
        //dp[cur][idx] = cnt1+cnt2;
        return cnt1+cnt2;
    }
}



class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for (int j = 0; j < coins.length; j++){
            for (int i = 1; i <= amount; i++){
                if (i-coins[j] >= 0) dp[i] += dp[i-coins[j]];
            }
            //System.out.println("dp " + dp[i]);
        }
        return dp[amount];
    }
}
*/