package array;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {

    public static List<Integer> spiralMatrix(List<List<Integer>> squareMatrix){
        List<Integer> spiralOrdering = new ArrayList<>();
        for(int offset = 0; offset < Math.ceil(0.5 * squareMatrix.size());offset ++){
            matrixLayerInClockwise(squareMatrix,offset,spiralOrdering);
        }
        return spiralOrdering;
     }

     private static void matrixLayerInClockwise (List<List<Integer>> squareMatrix,int offset, List<Integer> spiralOrdering) {

        if(offset == squareMatrix.get(offset).size() - offset -1) {
            //Square Matrix has odd dimensions , and we are at its center
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
            return;
        }
        for (int j = offset ; j< squareMatrix.get(offset).size() - offset - 1;j++){
            //Move Left
            spiralOrdering.add(squareMatrix.get(offset).get(j));
        }

        for (int i=offset ; i < squareMatrix.size() - offset - 1; i++) {
            //Move Down
            spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.get(offset).size() - offset - 1));
        }
        for (int j = squareMatrix.get(offset).size() - offset -1; j>offset ; j--) {
            spiralOrdering.add(squareMatrix.get(squareMatrix.size() - offset -1).get(j));
        }
        for (int i = squareMatrix.size() - offset -1;i> offset;i--) {
            spiralOrdering.add(squareMatrix.get(i).get(offset));
        }

     }

    public static void main(String[] args) {
        List<List<Integer>> squareMatrix = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        row1.add(4);

        List<Integer> row2 = new ArrayList<>();
        row2.add(5);
        row2.add(6);
        row2.add(7);
        row2.add(8);

        List<Integer> row3 = new ArrayList<>();
        row3.add(9);
        row3.add(10);
        row3.add(11);
        row3.add(12);

        List<Integer> row4 = new ArrayList<>();
        row4.add(13);
        row4.add(14);
        row4.add(15);
        row4.add(16);

        squareMatrix.add(row1);
        squareMatrix.add(row2);
        squareMatrix.add(row3);
//        squareMatrix.add(row4);

        List<List<Integer>> squareMatrix2 = new ArrayList<>();
        List<Integer> row5 = new ArrayList<>();
        row5.add(3);
        List<Integer> row6 = new ArrayList<>();
        row6.add(4);
        squareMatrix2.add(row5);
        squareMatrix2.add(row6);
        List<Integer> sprialOrder  =  spiralMatrix(squareMatrix2);
        for(int i : sprialOrder){
            System.out.print(i+" ");
        }
    }
}
