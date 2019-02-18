/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() <= 1) {
            return intervals;
        }
        Queue<Interval> pq = new PriorityQueue<>(16, (i1, i2) -> i1.start == i2.start ? 
                                                 i1.end - i2.end : i1.start - i2.start);
        pq.addAll(intervals);
        int start = -1;
        int end = -1;
        while (!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (start == -1) {
                start = cur.start;
                end = cur.end;
            } else if (end < cur.start) {
                res.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            } else {
                end = Math.max(end, cur.end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}