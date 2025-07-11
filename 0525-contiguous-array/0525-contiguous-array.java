class Solution {
    public int findMaxLength(int[] nums) {
        int net = 0, res = 0, len = nums.length;
        HashMap<Integer, Integer> map = new HashMap();    

        for (int i = 0; i < len; i++){
            if (nums[i] == 0){ 
                net--;
            } else {
                net++;
            }
            if (net == 0) res = Math.max(res, i+1);
            if (map.containsKey(net)){
                res = Math.max(res, i - map.get(net));
            } else {
                map.put(net, i);
            }  
        }

        return res;
    }
}