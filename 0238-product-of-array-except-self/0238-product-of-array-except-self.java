class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, flag = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0)
                prod *= nums[i];
            else if (flag == 0) flag = 1;
            else flag = 2;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (flag == 0)
                result[i] = prod/nums[i];
            else if (nums[i] == 0 && flag == 1)
                result[i] = prod;
            else 
                result[i] = 0;
                
        }
        return result;
    }
}