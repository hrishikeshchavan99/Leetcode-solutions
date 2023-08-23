class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //Arrays.sort(candidates);
        findCombinations(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    private void findCombinations(int ind, int target, int[] candidates, List<List<Integer>> ans, List<Integer> temp){
        if (target < 0) return;
        else if (target == 0) ans.add(new ArrayList<>(temp));
        else{
            for (int i = ind; i < candidates.length; i++){
                temp.add(candidates[i]);
                findCombinations(i, target - candidates[i], candidates, ans, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}