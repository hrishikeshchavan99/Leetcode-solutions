class Solution {
    public int findPeakElement(int[] nums) {
        // 1 2 3 5 4

        //1,2,3,1  7 2 1 

        int left = 0, right = nums.length-1;

        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}