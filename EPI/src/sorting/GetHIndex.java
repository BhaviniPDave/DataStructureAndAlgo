package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetHIndex {

    public  static  int hIndex(List<Integer> citations){
        Collections.sort(citations);

        int n = citations.size();
        for(int  i=0;i<n;i++){
            if(citations.get(i) >= n-i) {
                return n-i;
            }
        }
        return  0;
    }

    /**
     * If input array is sorted
     * Given the array is sorted, we should use binary search.
     * @param citations
     * @return
     */
    public  static  int hIndex2(List<Integer> citations){

        int n = citations.size();

        if(n == 0)
            return 0;
        if(n ==  1) {
            if (citations.get(0) == 0)
                return 0;
            else
                return 1;
        }

        int i = 0;
        int j = n-1;

        while (i < j) {

            int m = i + (j -i + 1 ) /2;
            if(citations.get(m) > n-j)
                j = m-1;
            else
                i = m;

        }
        if (citations.get(j) > n - j) {
            return n;
        }

        if (citations.get(j) == n - j) {
                return n - j;
        } else {
            return n - j - 1;
        }

    }


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(4);
        A.add(1);
        A.add(4);
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(5);
        A.add(6);

        System.out.println(hIndex(A));

        List<Integer> B = new ArrayList<>();

        B.add(1);
        B.add(1);
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(4);
        B.add(5);
        B.add(6);
        System.out.println(hIndex2(B));


    }
}
