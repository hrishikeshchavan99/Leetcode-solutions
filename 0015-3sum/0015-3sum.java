class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        int temp = 0;
        
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1, r = nums.length - 1;
            if (i == 0 || nums[i] != nums[i-1]){
            while (r > l){
                temp = nums[i] + nums[l] + nums[r];
                if (temp == 0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[r-1])
                        r--;
                    while (l < r && nums[l] == nums[l+1])
                        l++;
                    l++;
                    r--;
                }
                else if (temp > 0){
                    r--;
                }
                else{
                    l++;
                    
                }

            }
            }
        }        
        return result;           
    }
    
}