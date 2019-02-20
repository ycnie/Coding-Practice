class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (count > 0 && c == ' ') break;
            count =  c == ' ' ? count : count + 1;
        }
        return count;
    }
}

// Time: O(length of world)
// Space: O(1)