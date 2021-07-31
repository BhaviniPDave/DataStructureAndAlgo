package dailyCodingProblems;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class ProductArray {

    public int[] productArray(int[] arr) {
        int n = arr.length;
        int product[] = new int[n];
        int temp = 1;
        for(int i = 0;i<n;i++){
            product[i] = 1;
        }
        for(int i = 0;i<n;i++) {
            product[i] = temp;
            temp = temp * arr[i];
        }
        temp = 1;
        for(int i = n-1;i>=0;i--) {
            product[i] *= temp;
            temp *= arr[i];
        }
        return product;
    }

    public static void main (String[] args) {
        ProductArray obj = new ProductArray();
        int[] arr = {1, 2, 3, 4, 5};
        int[] product = obj.productArray(arr);
        for(int i: product){
            System.out.print(i + " , ");
        }
    }
}
