package leetcode.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class IntervalsMerge {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;

        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

        ArrayList<Interval> result = new ArrayList<>();

        int count = 1;
        Interval current = intervals.get(count - 1);
        Interval next;

        while(count < intervals.size()) {

            next = intervals.get(count);

            if(current.end >= next.start) {
                int bound = current.end >= next.end ? current.end : next.end;
                current = new Interval(current.start, bound);
            } else {
                result.add(current);
                current = next;
            }

            count++;
        }

        result.add(current);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(15, 18));
        list.add(new Interval(8, 10));
        list.add(new Interval(2, 6));
        list.add(new Interval(1, 3));
        System.out.println(merge(list));
    }
}
