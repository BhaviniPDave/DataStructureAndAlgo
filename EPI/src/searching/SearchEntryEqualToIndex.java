package searching;

import java.util.ArrayList;
import java.util.List;

public class SearchEntryEqualToIndex {
    public static int searchEntryEqualToItsIndex(List<Integer> A) {
        int left =0;
        int right = A.size() - 1;
        int  mid  = left + ((right-left)/2);
        int diff = A.get(mid) - mid;
        if(diff == 0)
            return mid;
        if(diff > 0)
            right = mid - 1;
        else //diff < 0
            left = mid + 1;
        return -1;
    }
    public static void main (String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-2);
        A.add(0);
        A.add(2);
        A.add(3);
        A.add(6);
        A.add(7);
        A.add(9);
        System.out.println(searchEntryEqualToItsIndex(A));
    }
}
