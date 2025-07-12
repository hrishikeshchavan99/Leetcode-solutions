class Solution {
    //view all 5 sols by heroes3001: https://leetcode.com/problems/house-robber/solutions/156523/from-good-to-great-how-to-approach-most-of-dp-problems/

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < n; i++){
            dp[i+1] = Math.max(dp[i-1] + nums[i], dp[i]);
        }

        return dp[n];
    }
    
}