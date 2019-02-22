class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1 = 0;
        int w2 = 0;
        int minDist = words.length - 1;
        while (w1 < words.length && w2 < words.length) {
            if (words[w1].equals(word1) && words[w2].equals(word2)) {
                minDist = Math.min(Math.abs(w1 - w2), minDist);
                w1 = w1 < w2 ? w1 + 1 : w1;
                w2 = w1 < w2 ? w2 : w2 + 1;
            } else if (words[w1].equals(word1)) {
                w2++;
            } else if (words[w2].equals(word2)) {
                w1++;
            } else {
                w1++;
                w2++;
            }
        }
        return minDist;
    }
}

// Time: O(n * (l1 + l2)) l1 and l2 are length of word1 and word2
// Space: O(1)