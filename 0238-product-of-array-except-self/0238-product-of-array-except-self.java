class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, flag = 0;
        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result1[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = nums.length-1; i >= 0; i--){
            result2[i] = prod;
            prod *= nums[i];
        }
         for (int i = 0; i < nums.length; i++)
            result1[i] = result1[i] * result2[i];
        
        return result1;
    }
}