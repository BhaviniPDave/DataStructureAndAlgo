package arrays.twoDArray;

public class TransposeMatrix {

    public static int[][] transpose (int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int[][] ans = new int[C][R];
        for(int r=0;r<R;r++){
            for (int c=0;c<C;c++) {
                ans[c][r] = A[r][c];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] transposeA = transpose(A);
        for(int r=0;r<transposeA.length;r++){
            for (int c=0;c<transposeA[0].length;c++) {
                System.out.print(transposeA[r][c]+" ");
            }
            System.out.println();
        }
    }
}
