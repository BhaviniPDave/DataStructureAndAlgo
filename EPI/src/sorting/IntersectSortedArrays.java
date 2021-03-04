package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
A = {2,3,3,5,5,6,7,7,8,12}
B = {5,5,6,8,8,9,10,10}
O/P = {5,6,8}
 */
public class IntersectSortedArrays {

    /**
     * Brute-Force
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> intersectTwoSortedArrays1(List<Integer> A, List<Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            if((i ==  0 || !A.get(i).equals(A.get(i-1))) && B.contains(A.get(i))) {
                intersectionAB.add(A.get(i));
            }
        }

        return intersectionAB;
    }

    public static List<Integer>  intersectTwoSortedArrays2(List<Integer> A, List<Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            if((i  == 0 || !A.get(i).equals( A.get(i-1))) && Collections.binarySearch(B,A.get(i)) >= 0){
                intersectionAB.add(A.get(i));
            }
        }
        return intersectionAB;
    }

    public static List<Integer>  intersectTwoSortedArrays3(List<Integer> A, List<Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        int i=0,j=0;
        while(i < A.size() && j < B.size()) {
            if(A.get(i).equals(B.get(j)) && (i  == 0 || !A.get(i).equals( A.get(i-1)))) {
                intersectionAB.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i) < B.get(j)) {
                i++;
            }
            else {
                j++;
            }
        }
        return intersectionAB;
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

        List<Integer> B = new ArrayList<>();
        B.add(5);
        B.add(5);
        B.add(6);
        B.add(8);
        B.add(8);
        B.add(9);
        B.add(10);

        List<Integer>  AB1 =  intersectTwoSortedArrays1(A,B);

        List<Integer> AB2 = intersectTwoSortedArrays2(A,B);

        List<Integer> AB3 = intersectTwoSortedArrays3(A,B);

        System.out.println(AB1);
        System.out.println(AB2);
        System.out.println(AB3);

    }
}
