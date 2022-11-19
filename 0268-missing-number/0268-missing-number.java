class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int num : nums){
            if (num != temp){
                return temp;
            }
            else
                temp++;
        }
        return temp;
    }
}