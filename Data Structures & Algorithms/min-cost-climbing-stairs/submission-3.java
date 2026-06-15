class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int ans = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost.length == 3) {
                return cost[1];
            }
            ans += cost[i];
            if (((i + 2) < cost.length) && cost[i + 1] < cost[i + 2]) i++;
            else i += 2;
        }
        return ans;
    }
}
