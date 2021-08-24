package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverLappingIntervalsG {

    class MyComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1]- b[1];
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new MyComparator() );
        int count = 0;
        int prev = 0;
        for(int i =1;i< intervals.length;i++) {
            if(intervals[prev][1] > intervals[i][0]) {
                if(intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            }
            else {
                prev = i;
            }
        }

        return count;
    }

    public static void main (String[] args) {
        NonOverLappingIntervalsG obj = new NonOverLappingIntervalsG();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }
}
