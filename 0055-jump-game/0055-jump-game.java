class Solution {
    public boolean canJump(int[] nums) {
        int low = 0, far = nums[0], prevFar = far, n = nums.length;

        while (far < n-1){
            prevFar = far;
            for (int i = low; i <= far && i < n; i++){
                far = Math.max(far, nums[i] + i);
            }
            if (far == prevFar) return false;
            low = prevFar+1;
        }
        return true;
    }
}