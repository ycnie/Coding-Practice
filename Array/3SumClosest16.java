class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int curTarget = target - nums[i];
            while (j < k) {
                res = Math.abs(curTarget - nums[j] - nums[k]) < Math.abs(target - res) ?
                    nums[i] + nums[j] + nums[k] : res;
                if (nums[j] + nums[k] == curTarget) {
                    return target;
                } else if (nums[j] + nums[k] < curTarget) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}