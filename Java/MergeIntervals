import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= prev[1]) {
                // Overlapping intervals, merge them
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev); // Add the last interval
        return merged.toArray(new int[merged.size()][]);
    }

    // Helper method to print 2D arrays
    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    // Main method to test the merge function
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        System.out.println("Original Intervals:");
        printIntervals(intervals);

        int[][] result = obj.merge(intervals);

        System.out.println("\nMerged Intervals:");
        printIntervals(result);
    }
}
