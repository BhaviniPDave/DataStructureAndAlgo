package array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

/**
 * 1337. The K Weakest Rows in a Matrix
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 */
public class KWeakestRowsInMatrix {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        int[] tempArr = new int[row];

        //finding no. of 1's for each row and storing them using count and row'th position for sorting : O(nlogm)
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (mat[i][mid] == 0) {
                    tempArr[i] = mid * row + i;
                    right = mid - 1;
                } else {
                    tempArr[i] = (mid + 1) * row + i;
                    left = mid + 1;
                }
            }
        }
        //Sorting : O(nlogn)
        Arrays.sort(tempArr);
        //After sorting, converting into original index value
        for (int i = 0; i < row; i++)
            tempArr[i] %= row;

        int[] kWeakRowMat = new int[k];
        for (int i = 0; i < k; i++)
            kWeakRowMat[i] = tempArr[i];

        return kWeakRowMat;
    }
    public static void main (String args[]) {
        int[][] mat = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] result = kWeakestRows(mat,3);
        for(int i: result) {
            System.out.println(i);
        }
    }
}
