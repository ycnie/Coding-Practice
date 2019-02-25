
// List
class MovingAverageFromDataStream346 {
    
    private int size;
    private List<Integer> window;
    private double curAve;
    private int curPos;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.curAve = 0;
        this.curPos = 0;
        window = new ArrayList<>();
    }
    
    public double next(int val) {
        if (window.size() < size) {
            curAve = (curAve * window.size() + val) / (double) (window.size() + 1);
            curPos++;
            window.add(val);
            return curAve;
        }
        curPos = curPos == size ? 1 : curPos + 1;
        curAve = (curAve * size - window.get(curPos - 1) + val) / (double) size;
        window.set(curPos - 1, val);
        return curAve;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

// In order to avoid removing element from the head of ArrayList,
// here I used an variable curPos to keep track of the current position of victim




// Queue
class MovingAverage {
    
    int size;
    int sum;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            sum += val;
        } else {
            int victim = queue.poll();
            queue.offer(val);
            sum = sum - victim + val;
        }
        return sum / (double) queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */