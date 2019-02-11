class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> inSub = new HashSet<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            while (inSub.contains(s.charAt(end))) {
                inSub.remove(s.charAt(start++));
            }
            inSub.add(s.charAt(end++));
            res = Math.max(res, end - start);
        }
        return res;
    }
}