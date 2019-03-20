class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> toMatch = new HashMap<>();
        for (char c : p.toCharArray()) {
            toMatch.put(c, toMatch.getOrDefault(c, 0) + 1);
        }
        int notMatched = toMatch.size();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i - start + 1 > p.length()) {
                Integer count = toMatch.get(s.charAt(start));
                if (count != null) {
                    toMatch.put(s.charAt(start), count + 1);
                    notMatched = count == 0 ? notMatched + 1 : notMatched;
                }
                start++;
            }
            Integer countCurrent = toMatch.get(s.charAt(i));
            if (countCurrent != null) {
                toMatch.put(s.charAt(i), countCurrent - 1);
                notMatched = countCurrent == 1 ? notMatched - 1 : notMatched;
            }
            if (notMatched == 0) {
                res.add(start);
            }
        }
        return res;
    }
}