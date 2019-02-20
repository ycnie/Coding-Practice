class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }
            for (int j = 0; j <= height.length; j++) {
                int h = j < height.length ? height[j] : 0;
                while (!stack.isEmpty() && height[stack.peekFirst()] >= h) {
                    int top = height[stack.pollFirst()];
                    int left = stack.isEmpty() ? -1 : stack.peekFirst();
                    maxArea = Math.max(maxArea, (j - left - 1) * top);
                }
                if (j < height.length) {
                    stack.offerFirst(j);
                }
            }
        }
        return maxArea;
    }
}

// Time: O(n^2)
// Space: O(n)