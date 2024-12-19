import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeOverlappingIntervals {
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals based on start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);

            if (currentInterval.end >= nextInterval.start) {
                // Overlapping intervals, merge them
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                // Non-overlapping interval, add currentInterval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last interval to the result
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals1 = Arrays.asList(new Interval(1, 3), new Interval(2, 4), new Interval(6, 8), new Interval(9, 10));
        System.out.println("Input intervals: " + intervals1);
        System.out.println("Merged intervals: " + mergeIntervals(intervals1));

        List<Interval> intervals2 = Arrays.asList(new Interval(6, 8), new Interval(1, 9), new Interval(2, 4), new Interval(4, 7));
        System.out.println("\nInput intervals: " + intervals2);
        System.out.println("Merged intervals: " + mergeIntervals(intervals2));
    }
}
