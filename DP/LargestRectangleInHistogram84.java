class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i < heights.length ? heights[i] : 0;
            while (!stack.isEmpty() && heights[stack.peekFirst()] >=  h) {
                int topIndex = stack.pollFirst();
                int height = heights[topIndex];
                int curLeft = stack.isEmpty() ? -1 : stack.peekFirst();
                maxArea = Math.max(maxArea, height * (i - curLeft - 1));
            }
            stack.offerFirst(i);
        }
        return maxArea;
    }
}