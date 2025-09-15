class Solution {
    public int firstMissingPositive(int[] nums) {
        
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int num: nums){
            if (num > 0){
                queue.offer(num);
            }
        }
        int last = 0;

        while (!queue.isEmpty()){
            int num = queue.poll();
            if (num - last > 1){
                return last+1;
            } else {
                last = num;
            }
        }
        return last+1;
    }
}