package letcode;

/**
 * @author CarryJey
 * @since 2019/1/2
 */
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public Interval setStart(int start) {
        this.start = start;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public Interval setEnd(int end) {
        this.end = end;
        return this;
    }
}
