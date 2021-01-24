package arrays.twoDArray;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *  Approach #1 Using BFS [Accepted]
 * Intuition
 *
 * A better brute force: Looking over the entire matrix appears wasteful and hence, we can use Breadth First Search(BFS) to limit the search to the nearest 0 found for each 1. As soon as a 0 appears during the BFS, we know that the 0 is nearest, and hence, we move to the next 1.
 *
 * Think again: But, in this approach, we will only be able to update the distance of one 1 using one BFS, which could in fact, result in slightly higher complexity than the Approach #1 brute force. But hey,this could be optimised if we start the BFS from 0s and thereby, updating the distances of all the 1s in the path.
 *
 * Algorithm
 *
 * For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
 * We start by adding all the cells with 0s to q.
 * Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX, which is updated during the BFS.
 * Pop the cell from queue, and examine its neighbours. If the new calculated distance for neighbour {i,j} is smaller, we add {i,j} to q and update dist[i][j].
 *
 * Complexity analysis
 *
 * Time complexity: O(r \cdot c)O(r⋅c).
 *
 * Since, the new cells are added to the queue only if their current distance is greater than the calculated distance, cells are not likely to be added multiple times.
 * Space complexity: O(r \cdot c)O(r⋅c). Additional O(r \cdot c)O(r⋅c) for queue than in Approach #1
 *
 * Approach #2 DP Approach [Accepted]
 * Intuition
 *
 * The distance of a cell from 0 can be calculated if we know the nearest distance for all the neighbours, in which case the distance is minimum distance of any neightbour + 1. And, instantly, the word come to mind DP!!
 * For each 1, the minimum path to 0 can be in any direction. So, we need to check all the 4 direction. In one iteration from top to bottom, we can check left and top directions, and we need another iteration from bottom to top to check for right and bottom direction.
 *
 * Algorithm
 *
 * Iterate the matrix from top to bottom-left to right:
 * Update \text{dist}[i][j]=\min(\text{dist}[i][j],\min(\text{dist}[i][j-1],\text{dist}[i-1][j])+1)dist[i][j]=min(dist[i][j],min(dist[i][j−1],dist[i−1][j])+1) i.e., minimum of the current dist and distance from top or left neighbour +1, that would have been already calculated previously in the current iteration.
 * Now, we need to do the back iteration in the similar manner: from bottom to top-right to left:
 * Update \text{dist}[i][j]=\min(\text{dist}[i][j],\min(\text{dist}[i][j+1],\text{dist}[i+1][j])+1)dist[i][j]=min(dist[i][j],min(dist[i][j+1],dist[i+1][j])+1) i.e. minimum of current dist and distances calculated from bottom and right neighbours, that would be already available in current iteration.
 *
 * Complexity analysis
 *
 * Time complexity: O(r \cdot c)O(r⋅c). 2 passes of r \cdot cr⋅c each
 * Space complexity: O(r \cdot c)O(r⋅c).
 *
 * DP Solution in JAVA doesn't solve all testcases
 */
public class Matrix01 {

    public static int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 ||
                        r >= m ||
                        c < 0 ||
                        c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }

                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[][] dist = new int[R][C];

        for(int r=0;r<dist.length;r++){
            for (int c=0;c<dist[0].length;c++) {
                dist[r][c] = Integer.MAX_VALUE;
            }
        }

        for(int r=0;r<R;r++) {
            for(int c=0;c<C;c++) {
                if(matrix[r][c] == 0) {
                    dist[r][c] =0;
                }
                else {
                    if(r>0) {
                        if(dist[r][c] == Integer.MAX_VALUE && dist[r - 1][c] == Integer.MAX_VALUE)
                            dist[r][c] = dist[r][c];
                        else if ( dist[r -1][c] == Integer.MAX_VALUE)
                            dist[r][c] = Math.min(dist[r][c], dist[r-1][c]);
                        else if (dist[r][c] != Integer.MAX_VALUE && dist[r-1][c] != Integer.MAX_VALUE)
                            dist[r][c] = Math.min(dist[r][c], dist[r - 1][c] + 1);
                    }
                    if(c>0) {
                        if(dist[r][c] == Integer.MAX_VALUE && dist[r][c - 1] == Integer.MAX_VALUE)
                            dist[r][c] = dist[r][c -1];
                        else if ( dist[r][c - 1] == Integer.MAX_VALUE)
                            dist[r][c] = Math.min(dist[r][c], dist[r][c - 1]) + 1;
                        else if (dist[r][c] != Integer.MAX_VALUE && dist[r][c - 1] != Integer.MAX_VALUE)
                            dist[r][c] = Math.min(dist[r][c], dist[r][c - 1] + 1);
                    }
                }
            }
        }

        for(int r = R-1;r>=0;r--) {
            for(int c=C-1;c>=0;c--) {
                if(r< R-1) {
                    dist[r][c] = Math.min(dist[r][c], dist[r + 1][c] + 1);
                }
                if(c<C-1) {
                    dist[r][c] = Math.min(dist[r][c], dist[r][c + 1] + 1);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,0,0,1,0,0,1,1,0},{1,0,0,1,0,1,1,1,1,1},{1,1,1,0,0,1,1,1,1,0},{0,1,1,1,0,1,1,1,1,1},{0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},{0,1,1,1,1,1,1,0,0,1},{1,1,1,1,1,0,0,1,1,1},{0,1,0,1,1,0,1,1,1,1},{1,1,1,0,1,0,1,1,1,1}};

        int[][] B = {{1,0,1},{0,1,0},{0,0,0}};
        int[][] result = updateMatrix(A);
        for(int r=0;r<result.length;r++){
            for (int c=0;c<result[0].length;c++) {
                System.out.print(result[r][c]+" ");
            }
            System.out.println();
        }
    }
}
