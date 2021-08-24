package arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWaterG {
    public int trap(int[] height) {
        // initialize output
        int result = 0;
        int n = height.length;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (height[lo] < height[hi]) {
                if (height[lo] > left_max)

                    // update max in left
                    left_max = height[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - height[lo];
                lo++;
            }
            else {
                if (height[hi] > right_max)

                    // update right maximum
                    right_max = height[hi];

                else
                    result += right_max - height[hi];
                hi--;
            }
        }

        return result;
    }

    public static void main (String[] args) {
        TrappingRainWaterG obj = new TrappingRainWaterG();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }
}
