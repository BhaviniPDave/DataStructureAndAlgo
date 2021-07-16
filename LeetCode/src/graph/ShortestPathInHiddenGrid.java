package graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * Solution:
 *
 * the size of board should be 1001 * 1001 and we start from the center (500, 500)
 * the outer rows and columns will all be marked as BLOCK;
 * Thus there's no need to check boundaries in dfs
 * Then the key to solve these type of questions is to reconstruct the board using dfs; After we know the board, the rest is very straightforward. This solutions works very well in these questions:
 *
 * 1810. Minimum Path Cost in a Hidden Grid
 * 1778. Shortest Path in a Hidden Grid
 * Note: if we don't know the size of board, we may use the technique in 489. Robot Room Cleaner: use a HashMap to store the visited "coordinates".
 */
public class ShortestPathInHiddenGrid {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static char[] FORWARD = {'U', 'D', 'L', 'R'};
    private static char[] BACKWARD = {'D', 'U', 'R', 'L'};

    private static final int UNVISITED = 0;
    private static final int PATH = 1;
    private static final int BLOCK = -1;

    private int N = 500;
    private int[][] board = new int[2 * N + 1][2 * N + 1];

    private GridMaster master;
    private int[] target;

    public int findShortestPath(GridMaster master) {
        this.master = master;

        dfs(N, N);
        return (target == null ? -1 : bfs());
    }

    private int bfs() {
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{N, N});
        board[N][N] = BLOCK;                                  // mark as visited

        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.pollFirst();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {
                    int newX = x + DIRECTIONS[d][0];
                    int newY = y + DIRECTIONS[d][1];

                    if (board[newX][newY] == BLOCK) continue;
                    if (newX == target[0] && newY == target[1]) return dist + 1;

                    board[newX][newY] = BLOCK;                 // mark as visited
                    queue.offerLast(new int[]{newX, newY});    // add to queue
                }
            }
            dist++;
        }
        return -1;
    }
    private void dfs(int x, int y) {
        if (master.isTarget()) target = new int[]{x, y};

        board[x][y] = PATH;    // mark current cell

        for (int d = 0; d < 4; d++) {
            int newX = x + DIRECTIONS[d][0];
            int newY = y + DIRECTIONS[d][1];

            char front = FORWARD[d];    // direction of moving
            char back = BACKWARD[d];    // direction of backtracking

            if (board[newX][newY] != UNVISITED) continue;

            if (!master.canMove(front)) {
                board[newX][newY] = BLOCK;
            } else {
                master.move(front);
                dfs(newX, newY);
                master.move(back);
            }
        }
    }
}
