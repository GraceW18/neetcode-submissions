class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ansIndices = new int[2];
        int sum = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                        min = i;
                        max = j;
                    } else if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                        min = j;
                        max = i;
                    }
                    ansIndices[0] = min;
                    ansIndices[1] = max;
                    return ansIndices;
                }
            }
        }
        return ansIndices;
    }
}
