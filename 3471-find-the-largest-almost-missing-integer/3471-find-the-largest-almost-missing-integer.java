class Solution {
    public int largestInteger(int[] nums, int k) {        
        int first = nums[0], last = nums[nums.length-1];
        if (k == 1) return findNonRepeatingMax(nums);
        if (k == nums.length) return findMax(nums);
        if (first == last) return -1;
        boolean firstAva = findNums(nums, first);
        boolean lastAva = findNums(nums, last);
        
        if (firstAva && lastAva) return -1;
        if (!firstAva && lastAva) return first;
        if (firstAva && !lastAva) return last;
        return Math.max(first, last);
    }

    private boolean findNums(int[] nums, int num){
        for (int i = 1; i < nums.length-1; i++){
            if (nums[i] == num){
                return true;
            }
        }
        return false;
    }    

    private int findMax(int[] nums){
        int max = 0;
        for (int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }

    private int findNonRepeatingMax(int[] nums){
        int[] count = new int[51];

        for (int num: nums){
            count[num]++;
        }

        for (int i = 50; i >= 0; i--){
            if (count[i] == 1) return i;
        }
        return -1;
    }
}