class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cur = map.get(target - nums[i]);
            if (cur == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{cur, i};
            }
        }
        return new int[2];
    }
}