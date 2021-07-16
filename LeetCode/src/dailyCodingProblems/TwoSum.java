package dailyCodingProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */
public class TwoSum {
    public boolean isTwoSumPossible(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
//        for(int i: arr) {
//            map.put(arr[i],k - arr[i]);
//        }
        for (int i =0;i<arr.length;i++) {
            map.put(arr[i],k - arr[i]);
            if(map.containsKey(k - arr[i]));
                return true;

        }
        return false;
    }
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] arr = {10,15,3,7};
        System.out.println(obj.isTwoSumPossible(arr,17));
    }
}
