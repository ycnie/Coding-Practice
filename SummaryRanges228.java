class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 1; j <= nums.length; j++) {
            if (j < nums.length && nums[j] - nums[j - 1] == 1) {
                continue;
            }
            if (i == j - 1) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j - 1]));
            }
            i = j;
        }
        return res;
    }
}

/*Basically the algorithms is to use two pointers: prev(i) and current(j).
  Numbers in the range of [i, j) are current continuous number.
  Numbers in the range of [j, nums.length) are unknown.
  Case0: j < nums.length && nums[j] - nums[j - 1] == 1 --> j++
  Case1: j == nums.length || j < nums.length && nums[j] - nums[j - 1] > 1
         case1.1: j - i == 1 --> res.add(character in index i)
         case1.2: j - i > 1 ---> res.add(characters from index i to index j-1)

*/
 
/*
Time: O(n)
Space: O(1)
*/