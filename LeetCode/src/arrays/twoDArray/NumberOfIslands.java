package arrays.twoDArray;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 * ]
 * Output: 1
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    private final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    ++islands;
                    connectWithWater(grid,i,j,m,n);
                }
            }
        }
        return islands;
    }
    private void connectWithWater (char[][] grid,int i,int j, int m, int n) {
        Queue<Integer> queue = new LinkedList<>();
        //2D -> 1D -> R * #cols(n) + C
        //1D -> 2D -> index / #cols = row, idex % #cols = column
        queue.add(i * n + j);
        grid[i][j] = '0';
        while(!queue.isEmpty()) {
            int index = queue.poll();
            int row = index / n;
            int col = index % n;
            for(int[] direction : DIRECTIONS) {
                int x = direction[0] + row;
                int y = direction[1] + col;
                if( x > -1 && x < m && y > -1 && y < n && grid[x][y] == '1') {
                    queue.add(x * n + y);
                    grid[x][y] = '0';
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        NumberOfIslands obj = new NumberOfIslands();
        System.out.println(obj.numIslands(grid));
    }
}
