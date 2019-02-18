class RemoveDuplicates80 {
	    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int count = 0;
        int prev = 0;
        int cur = 1;
        while (cur < nums.length) {
            if (nums[cur] != nums[prev]) {
                nums[++prev] = nums[cur++];
                count = 0;
                continue;
            }
            if (count < 1) {
                count++;
                nums[++prev] = nums[cur];
            }
            cur++;
        }
        return prev + 1;
    }
}

// Time: O(n)
// Space: O(1)