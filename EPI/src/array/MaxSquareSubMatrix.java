package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSquareSubMatrix {
    public int maxRectangleSubMatrix(List<List<Boolean>> A) {
        int maxRectangleArea = 0;
        List<Integer> table = new ArrayList<>(Collections.nCopies(A.get(0).size(), 0));
        for(int i = 0;i< A.size();i++) {
            for(int j = 0;j < A.get(i).size();j++) {
                table.set(j, A.get(i).get(j) ? table.get(j) + 1: 0);
            }
        }
//        maxRectangleArea = Math.max(maxRectangleArea, LargestRectangleUnderSkyLine.calculateLargetRectangle(table));
        return maxRectangleArea;
    }
    public static void main (String[] args) {
        MaxSquareSubMatrix obj = new MaxSquareSubMatrix();
        List<List<Boolean>> A = new ArrayList<>();
        System.out.print(obj.maxRectangleSubMatrix(A));
    }
}
