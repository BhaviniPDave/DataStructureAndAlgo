package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class FindFirstMissingPositiveEntry {

    public static int findFirstMissingPositive (List<Integer> A) {
        for (int i=0;i<A.size();i++) {
            while (0 < A.get(i) &&
            A.get(i) <= A.size() &&
            !A.get(A.get(i) - 1).equals(A.get(i))) {
                Collections.swap(A,A.get(i) -1,i);
            }
        }

        return IntStream.range(0,A.size())
                .filter(i -> A.get(i) != i+1)
                .findFirst()
                .orElse(A.size()) +1;
    }

    public static void main (String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(-1);
        list.add(5);
        list.add(1);
        list.add(-1);

        System.out.println(findFirstMissingPositive(list));
    }
}
