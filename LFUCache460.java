class LFUCache460 {
    
    class Entry {
        
        public int key;
        public int val;
        public int freq;
        public int ts;
        
        public Entry(int key, int val, int freq, int ts) {
            this.key = key;
            this.val = val;
            this.freq = freq;
            this.ts = ts;
        }
        
        @Override
        public boolean equals(Object obj) {
            return this.key == ((Entry) obj).key;
        }
        
        @Override
        public int hashCode() {
            return this.key;
        }
    }
    
    private int capacity;
    private int timeStamp;
    private Map<Integer, Entry> map;
    private Queue<Entry> minHeap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.timeStamp = 0;
        map = new HashMap<>();
        minHeap = new PriorityQueue<>(16, new Comparator<Entry>(){
            @Override
            public int compare(Entry o1, Entry o2) {
                if (o1.freq == o2.freq) {
                    return o1.ts - o2.ts;
                } else {
                    return o1.freq - o2.freq;
                }
            }
        });
    }
    
    public int get(int key) {
        if (this.capacity == 0 || !map.containsKey(key)) {
            return -1;
        }
        Integer value = map.get(key).val;
        update(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            update(key, value);
            return;
        }
        if (map.size() < this.capacity) {
            Entry newEntry = new Entry(key, value, 1, timeStamp++);
            map.put(key, newEntry);
            minHeap.add(newEntry);
        } else {
            Entry victim = minHeap.poll();
            map.remove(victim.key);
            Entry newEntry = new Entry(key, value, 1, timeStamp++);
            map.put(key, newEntry);
            minHeap.add(newEntry);
        }
        
    }
    
    private void update(int key, int value) {
        Entry prev = map.get(key);
        minHeap.remove(prev);
        Entry newEntry = new Entry(key, value, prev.freq + 1, timeStamp++);
        minHeap.add(newEntry);
        map.put(key, newEntry);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */