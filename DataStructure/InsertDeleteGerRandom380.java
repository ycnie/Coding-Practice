class InsertDeleteGerRandom380 {

    private Map<Integer, Integer> map;
    private List<Integer> container;
    private Random rand = new Random();
    private int size;
    
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        container = new ArrayList<>();
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size);
        container.add(size++, val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int curIndex = map.get(val);
        int swappedVal = container.get(size - 1);
        swap(container, size - 1, curIndex);
        map.put(swappedVal, curIndex);
        map.remove(val);
        size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int nextIndex = rand.nextInt(size);
        return container.get(nextIndex);
    }
    
    private void swap(List<Integer> container, int i, int j) {
        Integer temp = container.get(i);
        container.set(i, container.get(j));
        container.set(j, temp);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */