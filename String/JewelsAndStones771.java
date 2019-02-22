class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.isEmpty()) {
            return 0;
        }
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            count = set.contains(S.charAt(i)) ? count + 1 : count;
        }
        return count;
    }
}