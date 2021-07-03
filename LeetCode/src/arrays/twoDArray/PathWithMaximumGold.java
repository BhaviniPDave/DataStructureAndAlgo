package arrays.twoDArray;

/**
 * 1219. Path with Maximum Gold
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position, you can walk one step to the left, right, up, or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 * Example 1:
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 *
 * https://leetcode.com/problems/path-with-maximum-gold/
 */
public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                 max =  Math.max(max,getMaxValue(grid,i,j,m,n,visited));
            }
        }
        return max;
    }

    private int getMaxValue(int[][] grid,int i,int j,int m,int n, boolean[][] visited) {
        // i and j should be in limit
        //Value should not be zero
        //It should npt be visited
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int left = getMaxValue(grid, i , j - 1, m,n,visited);
        int right = getMaxValue(grid, i , j + 1, m,n,visited);
        int up = getMaxValue(grid, i - 1 , j , m,n,visited);
        int down = getMaxValue(grid, i + 1 , j , m,n,visited);
        visited[i][j] = false;

        return Math.max(left,Math.max(right,Math.max(up,down))) + grid[i][j];
    }
    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        PathWithMaximumGold obj = new PathWithMaximumGold();
        System.out.println(obj.getMaximumGold(grid));
    }
}
