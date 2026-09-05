class Solution {
    private int[] dp;
    private int earn(int i, List<Integer> nums, Map<Integer, Integer> m1) {
        if (i == nums.size() - 1) {
            return nums.get(i) * m1.get(nums.get(i));
        }
        if (i >= nums.size()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int m = 0;
        if (i + 1 < nums.size() && nums.get(i + 1) == nums.get(i) + 1) {
            int a = (nums.get(i) * m1.get(nums.get(i))) + earn(i + 2, nums, m1);
            m = Math.max(m, a);
        }
        if (i + 1 < nums.size() && nums.get(i + 1) != nums.get(i) + 1) {
            int a = (nums.get(i) * m1.get(nums.get(i))) + earn(i + 1, nums, m1);
            m = Math.max(m, a);
        }
        int a = earn(i + 1, nums, m1);
        m = Math.max(m, a);
        return dp[i] = m;
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> m1 = new TreeMap<>();
        for (int num : nums) {
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }
        List<Integer> v1 = new ArrayList<>();
        for (int key : m1.keySet()) {
            v1.add(key);
        }
        dp = new int[v1.size() + 5];
        Arrays.fill(dp, -1);
        return earn(0, v1, m1);
    }
}
