package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int j = Math.abs(nums[i]) -1;
            nums[j] = Math.abs(nums[j]) * -1;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
    public static void main (String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        int[] input2 = {1,1};

        List<Integer> res = findDisappearedNumbers(input2);
        System.out.println(res);
    }
}
