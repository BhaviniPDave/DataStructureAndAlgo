package arrays;

public class CellsWithOddValuesMatrix {
    public static int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] matrix = new int[n][m];
        for(int[] index:indices){
            for(int i=0;i<m;i++){
                matrix[index[0]][i]++;
            }
            for(int i=0;i<n;i++){
                matrix[i][index[1]]++;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(matrix[i][j]  % 2 !=  0)
                    count++;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        int[][] indices = new int[2][2];
        indices[0] = new int[]{0, 1};
        indices[1] = new int[]{1, 1};

        System.out.println(oddCells(2,3,indices));
    }
}
