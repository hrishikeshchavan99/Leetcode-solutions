class Solution {
    public int largestRectangleArea(int[] hts) {
        // solution by anton4,  https://www.youtube.com/watch?v=X0X6G-eWgQ8

        int len = hts.length;
        if (len == 0) return 0;
        int[] lessLeft = new int[len];//find height smaller than current to left for each bar
        int[] lessRight = new int[len];//find height smaller than current to right for each bar
        lessLeft[0] = -1;
        lessRight[len-1] = len;

        for (int i = 1; i < len; i++){
            int p = i-1;
            while (p >= 0 && hts[p] >= hts[i])
                p = lessLeft[p]; //main trick. keep going left until you find smaller bar. if not found, -1 will be kept.
            lessLeft[i] = p;
        } 
        for (int i = len-2; i >= 0; i--){
            int p = i+1;
            while (p <= len-1 && hts[p] >= hts[i])
                p = lessRight[p];// keep going right until you find smaller bar. if not found, len will be kept.
            lessRight[i] = p;
        } 
        int maxArea = 0;
        for (int i = 0; i < len; i++){
            maxArea = Math.max(maxArea, (lessRight[i]-lessLeft[i]-1)*hts[i]);//find maxArea with height = cur bar and max width for each bar.
        }
        return maxArea;
    }
}