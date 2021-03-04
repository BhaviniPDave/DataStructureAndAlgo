package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestNonConstrctiableValue {

    public static int smallestNonConstrctiableValue(List<Integer> A) {
        Collections.sort(A);
        int maxNonConstructiableAmount = 0;
        for(int a : A) {
            if(a > maxNonConstructiableAmount + 1){
                break;
            }
            maxNonConstructiableAmount += a;
        }
        return maxNonConstructiableAmount + 1;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(4);
        A.add(12);
        A.add(15);

        System.out.println(smallestNonConstrctiableValue(A));
    }
}
