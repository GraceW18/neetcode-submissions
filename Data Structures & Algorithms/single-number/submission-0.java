class Solution {
    public int singleNumber(int[] nums) {
        // for O(1) extra space, use XOR implementation
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans; // ans ^ ans = 0 & ans ^ 0 = ans
    }
}
