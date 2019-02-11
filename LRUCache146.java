class LRUCache146 {
    
    class DTreeNode {
        int key;
        int val;
        DTreeNode prev;
        DTreeNode next;
        
        public DTreeNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    private Map<Integer, DTreeNode> map;
    private DTreeNode head;
    private DTreeNode tail;
    private int capacity;
    
    private void addNode(DTreeNode node) {
        node.prev = head;
        node.next = head.next;
        node.prev.next = node;
        node.next.prev = node;
    }
    
    private void moveToHead(DTreeNode node) {
        deleteNode(node);
        addNode(node);
    }
    
    private void deleteNode(DTreeNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private DTreeNode removeTailNode() {
        DTreeNode victim = tail.prev;
        deleteNode(victim);
        return victim;
    }
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DTreeNode(-1, -1);
        tail = new DTreeNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (capacity == 0 || !map.containsKey(key)) {
            return -1;
        }
        DTreeNode curNode = map.get(key);
        moveToHead(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            DTreeNode curNode = map.get(key);
            curNode.val = value;
            moveToHead(curNode);
            map.put(key, curNode);
        } else if (map.size() < capacity) {
            DTreeNode newNode = new DTreeNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
        } else {
            DTreeNode victim = removeTailNode();
            map.remove(victim.key);
            DTreeNode newNode = new DTreeNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */