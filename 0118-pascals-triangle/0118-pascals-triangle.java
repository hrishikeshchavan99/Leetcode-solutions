class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
      
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < i+1; j++){
                if (j == 0 || j == i){
                    temp.add(1);
                }
                else {
                    temp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(new ArrayList(temp));
            temp.clear();
        }

        return res;
    }
}