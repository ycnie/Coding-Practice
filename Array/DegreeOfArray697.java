class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int degree = 0;;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> ls = map.getOrDefault(nums[i], new ArrayList<>());
            ls.add(i);
            map.put(nums[i], ls);
            degree = Math.max(degree, ls.size());
        }
        if (degree == 1) return 1;
        int minLength = nums.length;
        for (List<Integer> curList : map.values()) {
            if (curList.size() == degree) {
                minLength = Math.min(minLength, 
                                     curList.get(curList.size() - 1) - curList.get(0) + 1);
            }
        }
        return minLength;
    }
}

// Time: O(n)
// Space: O(n)