class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        findCombi(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void findCombi(int[] candidates, int target, int idx, List<Integer> temp ,List<List<Integer>> res){
        if (target < 0 || idx >= candidates.length) return;
        if (target == 0){
            res.add(new ArrayList(temp));
            return;
        }

        temp.add(candidates[idx]);
        findCombi(candidates, target-candidates[idx], idx, temp, res);
        temp.remove(temp.size()-1);

        findCombi(candidates, target, idx+1, temp, res);

    }
}