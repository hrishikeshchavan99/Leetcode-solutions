class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++){
            if (nums[i-1] == (nums[i]+nums[i-2])*2){
                count++;
            }
        }
        return count;
    }
}