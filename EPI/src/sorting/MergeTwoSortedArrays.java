package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrays {

    public static List<Integer> mergerTwoSortedArrays(List<Integer> A,int m,List<Integer> B,int n){
       int writeIndex = m + n -1;
       int a = m-1;
       int b = n-1;

       while(a >=0 && b>=0){
           A.set(writeIndex -- , A.get(a) > B.get(b) ?A.get(a--):B.get(b--));
       }
       while( b >= 0){
           A.set(writeIndex -- ,B.get(b--));
       }
        return   A;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(5);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(12);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);

        List<Integer> B = new ArrayList<>();
        B.add(5);
        B.add(5);
        B.add(6);
        B.add(8);
        B.add(8);
        B.add(9);
        B.add(10);

        List<Integer> merged = mergerTwoSortedArrays(A,10,B,7);
        System.out.println(merged);

    }
}
