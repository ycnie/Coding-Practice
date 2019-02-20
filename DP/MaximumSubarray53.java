// Simple DP solution
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempSum = Math.max(nums[i], tempSum + nums[i]);
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}

// Time: O(N)
// Space: O(1)



// Divide and Conquer
