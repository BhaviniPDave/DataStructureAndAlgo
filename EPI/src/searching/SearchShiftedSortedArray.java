package searching;

import java.util.ArrayList;
import java.util.List;

public class SearchShiftedSortedArray {

    /**
     * Brute  Force O(n)
     * @param A
     * @return
     */
    public static int searchSmallest1(List<Integer> A) {
        for(int i=1;i<A.size();i++){
            if(A.get(i) < A.get(i-1))
                return i;
        }
        return -1;
    }

    /**
     * Using Binary Search
     * @param A
     * @return
     */
    public static int searchSmallest2(List<Integer> A) {
        int left  = 0;
        int right = A.size() -1;
        while(left < right) {
            int  mid = left  + ((right-left)/2);
            if(A.get(mid) > A.get(right))
                left = mid +1; //Minimum in a sublist A.sublist(mid+1,right)
            else // A.get(mid) < A.get(right)
                right = mid; //Minimum must be in a A.sublist(left,mid)
        }
        return left;
    }

    public static  void main (String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(378);
        A.add(478);
        A.add(550);
        A.add(631);
        A.add(103);
        A.add(203);
        A.add(220);
        A.add(234);
        A.add(279);
        A.add(368);

        System.out.println(searchSmallest1(A));
        System.out.println(searchSmallest2(A));

    }
}
