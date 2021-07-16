package trees;

import java.util.Arrays;

/**
 * 1231. Divide Chocolate
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 *
 * You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces using k cuts, each piece consists of some consecutive chunks.
 *
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 *
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * Example 2:
 *
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], k = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 * Example 3:
 *
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], k = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 *
 * Solution:
 *
 * https://www.youtube.com/watch?v=Ppy9lvyMnuc
 */
public class DivideChocolateG {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 1;
        int high = Arrays.stream(sweetness).sum()/ k +1;
        while(low < high) {
            int mid = low + (high - low) /2;
            if(canSplit(sweetness, k, mid)) {
                low = mid;
            }
            else {
                high = mid -1;
            }
        }
        return low; //or return high
    }
    private boolean canSplit(int[] sweetness, int k, int mid) {
        int chunks = 0;
        int sum = 0;
        for(int i=0;i< sweetness.length;i++) {
            sum += sweetness[i];
            if(sum >= mid) {
                ++chunks;
                sum = 0;
            }
        }
        return chunks >= k + 1;
    }
}
