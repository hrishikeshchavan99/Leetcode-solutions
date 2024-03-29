class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, maj = nums[0];
        for (int i=1; i < nums.length; i++){
            if (nums[i] != maj){
                count--;
            }
            else
                count++;
            if (count == 0){
                maj = nums[i];
                count++;
            }
        }
        return maj;
    }
}