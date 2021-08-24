package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * We have n cities and m bi-directional roads where roads[i] = [ai, bi] connects city ai with city bi. Each city has a name consisting of exactly 3 upper-case English letters given in the string array names. Starting at any city x, you can reach any city y where y != x (i.e. the cities and the roads are forming an undirected connected graph).
 *
 * You will be given a string array targetPath. You should find a path in the graph of the same length and with the minimum edit distance to targetPath.
 *
 * You need to return the order of the nodes in the path with the minimum edit distance, The path should be of the same length of targetPath and should be valid (i.e. there should be a direct road between ans[i] and ans[i + 1]). If there are multiple answers return any one of them.
 *
 * The edit distance is defined as follows:
 *
 Follow-up: If each node can be visited only once in the path, What should you change in your solution?
 https://leetcode.com/problems/the-most-similar-path-in-a-graph/
 * Solution:
 *
 I started out with a graph based dfs approach only to realize that the minimum edit distances can be cached.
 So here's the idea for the bottom up approach -

 Start with creating a graph based on the given roads. Mark 1 for each road pairs.
 With this graph in mind, now let's look at the actual problem - we need to come up with a path that has
 least edit distance in comparison to the targetPath.
 So, if we know the minimum possible edit distance till a given index of the targetPath (say i),
 we will be able to compute the minimum possible edit distance till (i+1).
 The only catch here is that we have to check which nodes from ith column, can be used to calculate (i+1)th column for a given cell.
 We could find this from our initial graph.
 The perspective is shifted from graph traversal to a DP optimization.
 For each index we find the minimum possible edit distance using our graph and DP column of index-1. We stop the iteration at index=0.
 Once we computed the DP matrix bottom, we have to build our solution top down.
 Once again we traverse our DP matrix starting with row 0 and find the index which gives us the minimum edit distance.
 We store it in prevInd variable.
 From there, we find out the node which is connected to the previous node and has the minimum edit distance.
 We add this to our output. Update our prevInd to the current minimum index (curMinInd).
 Keep repeating step 7 till we reach the end of the target path.
 */
public class SimilarPathInAGraphG {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int[][] graph = new int[n][n];
        for(int[] road: roads){
            int x = road[0];
            int y = road[1];
            graph[x][y] = graph[y][x] = 1;
        }
        int targetLength = targetPath.length;
        int[][] dp = new int[targetLength][n];
        for(int i=0;i<n;i++){
            String targetCity = targetPath[targetLength -1];
            String currentCity = names[i];
            if(!targetCity.equals(currentCity))
                dp[targetLength -1][i] = 1;
        }
        for(int i=targetLength-2;i>=0;i--){
            String targetCity = targetPath[i];
            for(int j=0;j<n;j++){
                String curCity = names[j];
                if(!curCity.equals(targetCity))
                    dp[i][j] = 1;
                int minNextValue=Integer.MAX_VALUE;
                for(int x=0;x<n;x++){
                    if(graph[x][j]==1)
                        minNextValue = Math.min(dp[i+1][x],minNextValue);
                }
                dp[i][j] += minNextValue;
            }
        }
        List<Integer> op = new ArrayList<>();
        int prevInd=0;
        for(int i=1;i<n;i++){
            if(dp[0][i]<dp[0][prevInd]){
                prevInd = i;
            }
        }
        op.add(prevInd);
        for(int i=1;i<targetLength;i++){
            int curMinIndex=-1;
            int curMinVal = Integer.MAX_VALUE;
            for(int x =0; x<n;x++){
                if(graph[x][prevInd]!=1)
                    continue;
                if(dp[i][x]<curMinVal){
                    curMinVal = dp[i][x];
                    curMinIndex = x;
                }
            }
            op.add(curMinIndex);
            prevInd = curMinIndex;
        }
        return op;
    }
    public static void main (String[] args) {
        SimilarPathInAGraphG obj  = new SimilarPathInAGraphG();
        int n2=5;
        int[][] roads2 = {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}};
        String[] names2 = {"ATL","PEK","LAX","DXB","HND"};
        String[] targetPath2 = {"ATL","DXB","HND","LAX"};

        int n1 = 4;
        int[][] roads1 = {{1,0},{2,0},{3,0},{2,1},{3,1},{3,2}};
        String[] names1 = {"ATL","PEK","LAX","DXB"};
        String[] targetPath1 = {"ABC","DEF","GHI","JKL","MNO","PQR","STU","VWX"};

        int n3 = 6;
        int[][] roads3 = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        String[] names3 = {"ATL","PEK","LAX","ATL","DXB","HND"};
        String[] targetPath3 = {"ATL","DXB","HND","DXB","ATL","LAX","PEK"};

        List<Integer> result = obj.mostSimilar(n2,roads2,names2,targetPath2);
        for(int n: result) {
            System.out.println(n);
        }
    }
}
