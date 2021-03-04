package array;

import java.util.ArrayList;
import java.util.List;

public class PscalsTriangle {

    public static List<List<Integer>> pascalsTringle (int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> currRow = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                currRow.add((0<j && j<i)?(pascalTriangle.get(i-1).get(j-1) + pascalTriangle.get(i-1).get(j)):1);
            }
        }
        return pascalTriangle;
    }
    public static void main (String[] args) {
        List<List<Integer>> pascalTriangle = pascalsTringle(5);
        for(List<Integer> row: pascalTriangle){
            for(Integer  n: row){
                System.out.println(n +" ");
            }
            System.out.println();
        }
    }

}
