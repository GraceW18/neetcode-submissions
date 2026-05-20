class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>(); // frequency map for nums
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1); 
            // subtract because need to know how many occurences looked at
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = -(nums[i] + nums[j]);
                if (count.getOrDefault(target, 0) >  0) {
                    values.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            for (int k = i + 1; k < nums.length; k++) {
                count.put(nums[k], count.get(nums[k]) + 1);
            }
        }
        return values;
    }

}
