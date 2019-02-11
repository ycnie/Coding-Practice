class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> count = new HashMap<>();
        for (String s : words) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(16, 
            (e1, e2) -> e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue());
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (pq.size() < k) {
                pq.offer(e);
            } else {
                Map.Entry top = pq.peek();
                if ((int)top.getValue() < (int)e.getValue() || 
                   top.getValue() == e.getValue() && 
                    ((String)top.getKey()).compareTo(e.getKey()) > 0) {
                    pq.poll();
                    pq.offer(e);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res.add("");
        }
        for (int i = k - 1; i >= 0; i--) {
            res.set(i, pq.poll().getKey());
        }
        return res;
    }
}

// T: O(nlogk)
// Space: O(n)