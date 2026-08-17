class Solution {
    public int longestSubsequence(int[] nums) {
        int res = 0;
        boolean isNonZero = false;
        for (int num: nums){
            res = res ^ num;
            if (!isNonZero && num != 0){
                isNonZero = true;
            }
        }
        if (!isNonZero){
            return 0;
        }
        if (res == 0){
            return nums.length-1;
        }
        return nums.length;
    }
}