class Solution {
    public boolean checkValidCuts(int n, int[][] rect) {
        int len = rect.length;
        int[][] x = new int[len][2];
        int[][] y = new int[len][2];

        for (int i = 0; i < len; i++){
            x[i][0] = rect[i][0];
            y[i][0] = rect[i][1];
            x[i][1] = rect[i][2];
            y[i][1] = rect[i][3];
        }

        return canCut(x) || canCut(y);
    }
    private boolean canCut(int[][] arr){
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int pre = arr[0][1];
        int res = 0;

        for (int[] entry: arr){
            if (pre <= entry[0]){
                res++;
            }
            pre = Math.max(pre, entry[1]);
        }
        return res > 1;
    }
}