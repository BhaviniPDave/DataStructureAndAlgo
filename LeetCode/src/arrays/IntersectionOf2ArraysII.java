package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 */
public class IntersectionOf2ArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i< len1;i++) {
            list1.add(nums1[i]);
        }
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i< len2;i++) {
            list2.add(nums2[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<len1;i++) {
            int j = 0;
            while (j < list2.size()) {
                if (list1.get(i) == list2.get(j)) {
                    result.add(list2.get(j));
                    list2.remove(j);
                    break;
                }
                j++;
            }
        }
        int[] res = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        IntersectionOf2ArraysII obj = new IntersectionOf2ArraysII();
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        int[] result = obj.intersect(arr1,arr2);
        for(int i: result){
            System.out.println(i);
        }
    }
}
