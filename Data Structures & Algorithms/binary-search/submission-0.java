class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return search(nums, target, left, right);
    }
    private int search(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return -1;
        }
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return search(nums, target, mid + 1, right);
        } else if (target < nums[mid]) {
            return search(nums, target, left, mid - 1);
        }
        return 0;
    }
}
