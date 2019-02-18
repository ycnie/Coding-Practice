class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k).size();
            }
            List<Integer> curLs = map.getOrDefault(sum, new ArrayList<Integer>());
            curLs.add(i);
            map.put(sum, curLs);
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}

// Time: O(n)
// Space: O(n)

// Map<Integer, Integer>.
// We do not need specific index where the qualified sums exist.
// We just need to keep track of the number of times they exist.
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}