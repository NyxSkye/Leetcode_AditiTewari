class Solution {
    public List<List<Integer>> combinationSum(int[] candi, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candi, tar, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] candi, int curSum, int start, 
        List<Integer> curr, List<List<Integer>> res) {
        if (curSum == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (curSum < 0) {
            return; 
        }
        for (int i = start; i < candi.length; i++) {
            curr.add(candi[i]);
            backtrack(candi, curSum - candi[i], i, curr, res);            
            curr.remove(curr.size() - 1);
        }
    }
}
