package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIncreasingDecreasingArray {

    private enum SubArrayType {INCREASING, DECREASING};

    public static List<Integer> sortKIncreasingDecreasingArray (List<Integer> A) {
        //Decompose  A  into a set of  sorted arrays
        List<List<Integer>> sortedSubArrays = new ArrayList<>();
        SubArrayType subArrayType = SubArrayType.INCREASING;
        int startIndex  = 0;
        for (int i=1;i<= A.size();i++){
            if (i == A.size() ||   //  A is ended. Adds the last subArray
                 ( A.get(i-1) < A.get(i) && subArrayType == SubArrayType.DECREASING) ||
                    (A.get(i-1) >= A.get(i) && subArrayType  == SubArrayType.INCREASING)
            ) {
                List<Integer> subList = A.subList(startIndex,i);
                if(subArrayType == SubArrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubArrays.add(subList);
                startIndex = i;
                subArrayType = (subArrayType == SubArrayType.INCREASING? SubArrayType.DECREASING : SubArrayType.INCREASING);
            }
        }
        return SortedArraysMerge.mergeSortedArrays(sortedSubArrays);
    }
}
