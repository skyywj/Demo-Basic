package letcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CarryJey
 * @since 2019/1/2 desc:区间排序
 */
public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList<>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));

        for (Interval interval : intervals) {
            if (res.isEmpty() || res.peekLast().end < interval.start) {
                res.add(interval);
            } else {
                if (res.peekLast().end < interval.end) {
                    res.peekLast().end = interval.end;
                }
            }
        }
        return res;
    }
}
