class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> resIndex = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            resIndex.offer(i);
        }
        int[] res = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            int curIndex = resIndex.poll();
            res[curIndex] = deck[i];
            resIndex.offer(resIndex.poll());
        }
        return res;
    }
}