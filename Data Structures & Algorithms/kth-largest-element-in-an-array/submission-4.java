class Solution {
    public int findKthLargest(int[] nums, int k) {
       return quickSelect(nums, k - 1); 
    }
    private int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pivotIndex = split(nums, left, right);
            if (pivotIndex == k) {
                return nums[pivotIndex];
            }
            if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return nums[left];
    }
    private int split(int[] nums, int left, int right) {
        int pivot = nums[right];
        int fillIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, fillIndex);
                fillIndex++;
            }
        }
        swap(nums, fillIndex, right);
        return fillIndex;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
