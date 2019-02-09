class RemoveElement27 {
	    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != val) {
                l++;
            } else if (nums[r] != val) {
                swap(nums, l++, r--);
            } else {
                r--;
            }
        }
        return l;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time: O(n)
// Space: O(1)