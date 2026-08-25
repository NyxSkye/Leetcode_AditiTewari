class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        int start = -1;
        for (int i=lower;i<=upper;i++){
            if (!set.contains(i)) {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    result.add(Arrays.asList(start, i - 1));
                    start = -1;
                }
            }
        }
        if (start != -1) {
            result.add(Arrays.asList(start, upper));
        }
        
        return result;
    }
}
