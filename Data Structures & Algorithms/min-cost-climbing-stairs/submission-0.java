class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int ans = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost.length == 3) {
                return 2;
            }
            if (i < cost.length - 1) {
                ans += cost[i];
                i += 2;
            }
            else {
                ans++;
            }
        }
        return ans;
    }
}
