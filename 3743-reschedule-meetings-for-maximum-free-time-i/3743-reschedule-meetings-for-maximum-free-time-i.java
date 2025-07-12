class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int events = startTime.length;
        int[] gaps = new int[events+1];

        gaps[0] = startTime[0];
        for (int i = 1; i < events; i++){
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[events] = eventTime - endTime[events-1];

        int sum = 0, max = 0;
        for (int i = 0; i < gaps.length; i++){
            sum += gaps[i];
            if (i > k){
                sum -= gaps[i-k-1];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}