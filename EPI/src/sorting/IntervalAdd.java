package sorting;

import java.util.ArrayList;
import java.util.List;

public class IntervalAdd {

    public static class Interval {
        public int left;
        public int right;
        public Interval(int left,int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static List<Interval> addInterval(List<Interval> disjointIntervals, Interval newInterval) {
        int i=0;
        List<Interval> result = new ArrayList<>();
        while (i < disjointIntervals.size() && newInterval.left > disjointIntervals.get(i).right){
            result.add(disjointIntervals.get(i));
            i++;
        }
        while (i< disjointIntervals.size() && newInterval.right >= disjointIntervals.get(i).left) {
            //if [a,b] and [c,d] overlap their union is [Min(a,c),Max(b,d)]
            newInterval  = new Interval(
                    Math.min(newInterval.left,disjointIntervals.get(i).left),
                    Math.max(newInterval.right,disjointIntervals.get(i).right)
            );
            i++;
        }
        result.add(newInterval);

        result.addAll(disjointIntervals.subList(i,disjointIntervals.size()));

        return result;
    }

    public static void main (String[] args) {
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(-4,-1));
        A.add(new Interval(0,2));
        A.add(new Interval(3,6));
        A.add(new Interval(7,9));
        A.add(new Interval(11,12));
        A.add(new Interval(14,17));

        System.out.println(addInterval(A,new Interval(1,8)));

    }
}
