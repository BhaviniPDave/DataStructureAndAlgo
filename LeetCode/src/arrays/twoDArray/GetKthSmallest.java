package arrays.twoDArray;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GetKthSmallest {

    public static int kthSmallest(int[][] mat, int k) {
        List<Integer> li = new ArrayList();
        for(int i=0;i<mat[0].length;i++)
            li.add(mat[0][i]);
        for(int i=1;i<mat.length;i++){
            li = getKthSmallest(mat[i],li,k);
        }
        return li.get(k-1);
    }

    private static List<Integer> getKthSmallest(int[] arr,List<Integer> li,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<li.size();j++){
                pq.offer(arr[i]+li.get(j));
            }
        }
        List<Integer> res = new ArrayList();
        for(int i=1;i<=k && !pq.isEmpty();i++){
            int sum = pq.poll();
            res.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] A = {{1,3,11},{2,5,6}};
        System.out.println(kthSmallest(A,5));
    }
}
