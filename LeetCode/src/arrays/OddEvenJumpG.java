package arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * 975. Odd Even Jump
 * You are given an integer array arr. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.
 *
 * You may jump forward from index i to index j (with i < j) in the following way:
 *
 * During odd-numbered jumps (i.e., jumps 1, 3, 5, ...), you jump to the index j such that arr[i] <= arr[j] and arr[j] is the smallest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 * During even-numbered jumps (i.e., jumps 2, 4, 6, ...), you jump to the index j such that arr[i] >= arr[j] and arr[j] is the largest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 * It may be the case that for some index i, there are no legal jumps.
 * A starting index is good if, starting from that index, you can reach the end of the array (index arr.length - 1) by jumping some number of times (possibly 0 or more than once).
 *
 * Return the number of good starting indices.
 */
public class OddEvenJumpG {
    public int oddEvenJumps(int[] A) {
        int n  = A.length;
        int res = 1;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);
            if (hi != null)
                higher[i] = lower[(int)hi.getValue()];
            if (lo != null)
                lower[i] = higher[(int)lo.getValue()];
            if (higher[i])
                res++;
            map.put(A[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        OddEvenJumpG obj = new OddEvenJumpG();
        int[] A = {5,1,3,4,2};
        System.out.println(obj.oddEvenJumps(A));
    }
}
