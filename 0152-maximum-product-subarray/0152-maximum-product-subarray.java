class Solution {
    public int maxProduct(int[] nums) {
        int l = 0, r = 0, res = nums[0], len = nums.length-1;
        for (int i = 0; i <= len; i++){
            l = ((l == 0) ? 1: l) * nums[i];
            r = ((r == 0) ? 1: r) * nums[len-i];

            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}