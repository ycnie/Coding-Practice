class RemoveDuplicatesfromSortedArray26 {
	    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 0;
        int cur = 1;
        while (cur < nums.length) {
            if (nums[cur] != nums[prev]) {
                nums[++prev] = nums[cur++];
            } else {
                cur++;
            }
        }
        return prev + 1;
    }
}