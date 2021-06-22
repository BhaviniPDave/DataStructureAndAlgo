package array;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 *
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 *
 * Input: grid = [[-1]]
 * Output: 1
 */
public class CountNegativeNumbersInMatrix {

    public static int countNegatives2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int row = m-1;
        int col = 0;

        while(row >=0 && col < n) {
            if(grid[row][col] < 0) {
                count += n - col;
                row --;
            }
            else{
                col ++;
            }
        }
        return count;
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=0;i< grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] < 0)
                    count++;
            }
        }
        return count;
    }
    public static void main (String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives2(grid));
    }
}
