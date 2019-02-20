class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                res += leftMax - height[l++];
            } else {
                res += rightMax - height[r--];
            }
        }
        return res;
    }
}

// Time: O(n)
// Space: O(1)