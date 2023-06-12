class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid = 0, min = Integer.MAX_VALUE;
        while (low <= high){
            mid = low + (high-low)/2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return min;
    }
}