package searching;

import java.util.ArrayList;
import java.util.List;

public class SearchFirstKey {

    public static int searchFirstOfK(List<Integer> A, int k) {
        int  result = -1;
        int left =  0;
        int right = A.size() -1;
        while (left <= right) {
            int mid = left + ((right - left)/2);
            if(A.get(mid) > k){
                right = mid-1;
            }
            else if(A.get(mid) < k){
                left = mid + 1;
            }
            else {
                result = mid;
                right = mid -1;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-14);
        A.add(-10);
        A.add(2);
        A.add(108);
        A.add(108);
        A.add(243);
        A.add(285);
        A.add(285);
        A.add(285);
        A.add(401);

        System.out.println(searchFirstOfK(A,285));
    }
}
