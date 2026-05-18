class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return testSum(0, 0, nums, target);
    }
    private int testSum(int i, int totalSum, int[] nums, int target) {
        if (i == nums.length) {
            return (totalSum == target) ? 1 : 0;
        }
        return testSum(i + 1, totalSum + nums[i], nums, target) 
        + testSum(i + 1, totalSum - nums[i], nums, target);

    }
}
