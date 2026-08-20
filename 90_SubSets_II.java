class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        result.forEach(Collections::sort);
        List<List<Integer>> fResult = new ArrayList<>(new LinkedHashSet<>(result));
        return fResult;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        current.remove(current.size() - 1);
        generateSubsets(index + 1, nums, current, result);
    }
}