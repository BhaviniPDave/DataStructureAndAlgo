package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllComposites {

    private List<Integer> findAllComposites(int[] arr) {
        return findAllComposites(arr, arr.length);
    }

    private List<Integer> findAllComposites(int[] arr, int n) {
        if (n == 1) {
            return Arrays.asList(1, arr[n - 1]);
        }
        List<Integer> res = findAllComposites(arr, n - 1);
        List<Integer> temp = new LinkedList<>(res);
        for (int num : res) {
            temp.add(num * arr[n - 1]);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3};
        FindAllComposites fac = new FindAllComposites();
        fac.findAllComposites(arr).forEach(num -> System.out.print(num + " "));
    }
}
