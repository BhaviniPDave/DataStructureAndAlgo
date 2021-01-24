package arrays.twoDArray;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 *
 * Example 3:
 *
 * Input: matrix = [], target = 0
 * Output: false
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 )
            return false;
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowIdx = matrix.length - 1;
        int colIdx = matrix[0].length - 1;
        while (rowIdx >= 0 && colIdx >= 0) {
            int val = matrix[rowIdx][colIdx];
            if (val == target) {
                return true;
            }
            if (target >= matrix[rowIdx][0]) {
                colIdx--;
                if (colIdx < 0) {
                    colIdx = matrix[0].length - 1;
                    rowIdx--;
                }
            }
            else {
                rowIdx--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] A = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix2(A,3));
    }
}
