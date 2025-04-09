class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        int j = nums.length-1;
        if (i < 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        while (nums[i] >= nums[j]){
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
        return;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return;
    }

    private void reverse(int[] nums, int i, int j){
        while (i < j) swap(nums, i++, j--);
    }
}