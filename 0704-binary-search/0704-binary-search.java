class Solution {
    public int search(int[] nums, int target) {
        int l = nums.length;
        
        if (l == 0) return -1;
        
        int left = 0;
        int right = l-1;
        
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}