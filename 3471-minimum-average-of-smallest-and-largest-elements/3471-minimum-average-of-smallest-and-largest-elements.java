class Solution {
    public double minimumAverage(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int l = 0, r = n-1;
        double res = Double.MAX_VALUE;
        while (l < r){
            res = Math.min(res, (double)(nums[l]+nums[r])/2);
            l++;
            r--;
        }
        return res;
        
    }
}