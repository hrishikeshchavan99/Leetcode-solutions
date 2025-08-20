
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len+1];
        return lengthOfLIS(nums, 0, -1, dp);
    }

    public int lengthOfLIS(int[] nums, int idx, int lastIdx, int[][] dp){

        if (idx == nums.length){
            return 0;
        }
        
        if (dp[idx][lastIdx+1] != 0 ){
            return dp[idx][lastIdx+1];
        }
    
        int res1 = lengthOfLIS(nums, idx+1, lastIdx, dp);
        int res2 = 0;
        if (lastIdx == -1 || nums[idx] > nums[lastIdx]){
            res2 = 1 + lengthOfLIS(nums, idx+1, idx, dp);
        }

        dp[idx][lastIdx+1] = Math.max(res1, res2);

        return dp[idx][lastIdx+1];


    } 
}










/*
class Solution {
    //Watch strivers video
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n+1];
        //dp[i+1] indicates max length of subsequence ending at i with last element nums[i]
        //for each index i, we will try to add nums[i] to existing sunsequence from index 0 to i-1 if possible
        //this will give max length subsequence till i and we store it in dp[i+1] 
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j])
                    dp[i+1] = Math.max(dp[i+1], dp[j+1] + 1);
            }
            max = Math.max(max, dp[i+1]);
        }

        return max;
    }

}

*/

//striver binary soln: https://www.youtube.com/watch?v=on2hvxBXJH4
/*
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            int j = Arrays.binarySearch(dp, 0, len, nums[i]);
            if(j < 0) j = -(j + 1);
            dp[j] = nums[i];
            if (j == len) len++;
        }
        return len;
    }
}
*/

