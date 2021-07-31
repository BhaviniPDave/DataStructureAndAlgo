package dailyCodingProblems;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class FindFirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //Base Case
        int contains = 0;
        for(int i = 0;i < n;i++) {
            if(nums[i] == 1) {
                contains++;
                break;
            }
        }

        if(contains == 0)
            return 1;

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for(int i = 0;i<n;i++) {
            if(nums[i] <=0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.

        for(int i = 0;i < n;i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if(a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;

    }
    public static void main (String[] args) {
        FindFirstMissingPositive obj = new FindFirstMissingPositive();
        int[] arr = {3,4,-1,1};
        System.out.println(obj.firstMissingPositive(arr));
    }
}
