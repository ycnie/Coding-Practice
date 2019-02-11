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