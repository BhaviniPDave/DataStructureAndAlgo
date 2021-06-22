package arrays;

/**
 * 485. Max Consecutive Ones
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int fast = 0;
        int slow = -1;

        while (fast != nums.length) {
            if (nums[fast] == 1) {
                max = Math.max(max, fast - slow);
            } else {
                slow = fast;
            }
            fast++;
        }
        return max;
    }
    public int findMaxConsecutiveOnes2(int[] nums) {
        int i=0,j=0;
        int max = 0;
        while(i<nums.length) {
            while(j<nums.length && nums[j] != 0) {
                j++;
            }
            if((j - i) > max)
                max = j-i;
            while(j< nums.length && nums[j] != 1)
                j++;
            i = j;
        }
        return max;
    }
    public static void main(String[] args) {
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int[] arr = {1,0,1,1,0,1};
        System.out.println(obj.findMaxConsecutiveOnes2(arr));
    }
}
