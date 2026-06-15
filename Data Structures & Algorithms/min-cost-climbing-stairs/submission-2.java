class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int ans = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost.length == 3) {
                return cost[1];
            }
            if (i < cost.length) {
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
