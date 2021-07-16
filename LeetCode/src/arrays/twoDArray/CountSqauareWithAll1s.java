package arrays.twoDArray;

public class CountSqauareWithAll1s {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==1 && n==1) return matrix[0][0];
        int count = 0;

        int [][] dp = new int [m+1][n+1];

        for(int i =1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] ==1){
                    int a = dp[i-1][j-1];
                    int b = dp[i-1][j];
                    int c = dp[i][j-1];
                    if(a ==0 || b == 0 || c ==0) dp[i][j] =1;
                    else if (a ==b && b ==c) dp[i][j] = a+1;
                    else dp[i][j] = Math.min(Math.min(a,b), Math.min(a,c)) +1;

                }
                count+=dp[i][j];
            }

        }
        return count;
    }

    public static void main (String[] args) {
        CountSqauareWithAll1s obj = new CountSqauareWithAll1s();
        int[][] arr = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(obj.countSquares(arr));
    }
}
