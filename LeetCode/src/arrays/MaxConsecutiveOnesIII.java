package arrays;

/**
 * 1004. Max Consecutive Ones III
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Hint 1:
 * One thing's for sure, we will only flip a zero if it extends an existing window of 1s.
 * Otherwise, there's no point in doing it, right? Think Sliding Window!
 *
 * Since we know this problem can be solved using the sliding window construct, we might as well focus in that direction for hints.
 * Basically, in a given window, we can never have > K zeros, right?
 * We don't have a fixed size window in this case. The window size can grow and shrink depending upon the number
 * of zeros we have (we don't actually have to flip the zeros here!).
 * The way to shrink or expand a window would be based on the number of zeros that can still be flipped and so on.
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        /*
            Longest window with atmost k zeros
        */
        int begin = 0;
        int end = 0;
        int n = nums.length;
        // maximum conseective one's
        int maxLength = 0;

        while(end < n) {
            // if nums[i] == 1 then, we have a valid window => check for maxConsecutiveOne's
            if(nums[end] == 1) {
                maxLength = Math.max(maxLength, end-begin+1);
                end++;
            }
            else {
                // if nums[i] == 0 : two cases
                if(k > 0) { // valid window  ( because we need to include atmost k 0's )
                    k-=1;
                    maxLength = Math.max(maxLength, end-begin+1);
                    end++;
                } else {
                    // invalid window =>
                    if(nums[begin] == 0) k++;
                    begin++;
                }
            }
        }
        return maxLength;
    }
}
