package arrays;

import java.util.Arrays;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.
 *
 * Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 * Example 2:
 *
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
 * The difference between the maximum and minimum is 1-0 = 1.
 * Example 3:
 *
 * Input: nums = [6,6,0,1,1,4,6]
 * Output: 2
 * Example 4:
 *
 * Input: nums = [1,5,6,14,15]
 * Output: 1
 *
 * Solution:
 *
 * Here you have to find the minumum difference between the largest and the smallest number by making/considering any other three numbers in the array equal to whatever number from the same array. Confused? I was too .
 *
 * It's actually simple, all you have to do is to see this problem in a different way. It's asking us to return the minimum difference between smallest and largest number of the array considering there are only N - 3 element at each run (N - length of array).
 * The reason we substracted by 3 is because in the problem it says we can replace any number using three move. Using this we will just increment our pointers (walker and looper) and get the difference between the first element and the last element in that range and get the minimum from it to get the result.
 * n-3-1 will be the last element in the first interation.
 *
 * One more thing for array with length between 0 - 4 the answer will always be 0, reason being we can just replace the maximum number with the other three and then difference will be 0.
 */
public class MinDifferenceG {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n < 5) return 0;
        Arrays.sort(nums);//O(nLogn) this uses TimSort
        int walker = 0, looper = n - 3 - 1;
        int res = Integer.MAX_VALUE;
        while(walker < n && looper < n) {
            res = Math.min(res, (nums[looper++] - nums[walker++]));
        }
        return res;
    }

    public static void main(String[] args) {
        MinDifferenceG obj = new MinDifferenceG();
        int[] arr = {1,5,6,14,15};
        System.out.println(obj.minDifference(arr));
    }
}
