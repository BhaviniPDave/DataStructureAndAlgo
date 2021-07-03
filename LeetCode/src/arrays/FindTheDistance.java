package arrays;

import java.util.Arrays;

/**
 * 1385. Find the Distance Value Between Two Arrays
 * Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
 *
 * The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 *
 * Find total elements from arr1 which does not have any matching values from arr2 (Refer above condition of matching elements)
 */
public class FindTheDistance {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0;
        for (int n : arr1)
            if (isDistanceValue(n, arr2, d))
                result++;
        return result;
    }

    private boolean isDistanceValue(int n, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr2[middle] > n)
                right = middle - 1;
            else if (arr2[middle] < n)
                left = middle + 1;
            else
                return false;
        }
        if (left < arr2.length && arr2[left] - n <= d)
            return false;
        if (right >= 0 && n - arr2[right] <= d)
            return false;
        return true;
    }

    public static void main(String[] args) {
        FindTheDistance obj = new FindTheDistance();
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,8,1};
        int d = 2;
        int result = obj.findTheDistanceValue(arr1,arr2,d);
        System.out.println(result);
    }
}
