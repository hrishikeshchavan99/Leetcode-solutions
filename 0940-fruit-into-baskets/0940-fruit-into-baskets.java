class Solution {
    public int totalFruit(int[] fruits) {
        int idx = 0, p1 = -1, p2 = -1, p1i = -1, p2i = -1, max = 0, res = 0;

        while (idx < fruits.length){
            //System.out.println(idx);
            if (p1 == fruits[idx]){
                //p1i = idx;
                max++;
                idx++;
            } else if (p2 == fruits[idx]){
                //p2i = idx;
                max++;
                idx++;
            } else if (p1 == -1){
                p1i = idx;
                p1 = fruits[idx++];
                max++;
            } else if (p2 == -1){
                p2i = idx;
                p2 = fruits[idx++];
                max++;
            } else {
                res = Math.max(res, max);
                max = 0;
                idx = Math.max(p1i, p2i);
                p1 = -1;
                p2 = -1;
                p1i = -1;
                p2i = -1;
            }
        }
        return Math.max(res, max);
    }
}