class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] sequence = new int[nums.length];
        Arrays.fill(sequence, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    sequence[i] = Math.max(sequence[i], 1 + sequence[j]);
                }
            }
        }
        return Arrays.stream(sequence).max().getAsInt();
    }
}
