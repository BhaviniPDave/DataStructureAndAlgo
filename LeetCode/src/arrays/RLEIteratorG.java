package arrays;

public class RLEIteratorG {
    int index;
    int [] A;
    public RLEIteratorG(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        while(index < A.length && n > A[index]){
            n = n - A[index];
            index += 2;
        }

        if(index >= A.length){
            return -1;
        }

        A[index] = A[index] - n;
        return A[index + 1];
    }

    public static void main (String[] args) {
        int[] A = {3, 8, 0, 9, 2, 5};
        RLEIteratorG obj = new RLEIteratorG(A);
        System.out.println(obj.next(2));
        System.out.println(obj.next(1));
        System.out.println(obj.next(1));
        System.out.println(obj.next(2));

    }
}
