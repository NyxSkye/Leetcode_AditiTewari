class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> invalid = new HashSet<>();
        int prev = -1;
        for (int num : nums) {
            if (num != prev) {
                if (seen.contains(num)) {
                    invalid.add(num);
                }
                seen.add(num);
            }
            prev = num;
        }
        return seen.size() - invalid.size();
    }
}
