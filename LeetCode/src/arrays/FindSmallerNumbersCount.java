package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSmallerNumbersCount {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] original = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++) {
            result[i] = list.indexOf(original[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6,4,5,8};
        System.out.println(smallerNumbersThanCurrent(nums));
    }
}
