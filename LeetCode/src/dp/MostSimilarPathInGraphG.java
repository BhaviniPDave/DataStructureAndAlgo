package dp;

import java.util.LinkedList;
import java.util.List;

/**
 * 1548. The Most Similar Path in a Graph
 * We have n cities and m bi-directional roads where roads[i] = [ai, bi] connects city ai with city bi. Each city has a name consisting of exactly 3 upper-case English letters given in the string array names. Starting at any city x, you can reach any city y where y != x (i.e. the cities and the roads are forming an undirected connected graph).
 *
 * You will be given a string array targetPath. You should find a path in the graph of the same length and with the minimum edit distance to targetPath.
 *
 * You need to return the order of the nodes in the path with the minimum edit distance, The path should be of the same length of targetPath and should be valid (i.e. there should be a direct road between ans[i] and ans[i + 1]). If there are multiple answers return any one of them.
 *
 * Example 1:
 * Input: n = 5, roads = [[0,2],[0,3],[1,2],[1,3],[1,4],[2,4]], names = ["ATL","PEK","LAX","DXB","HND"], targetPath = ["ATL","DXB","HND","LAX"]
 * Output: [0,2,4,2]
 * Explanation: [0,2,4,2], [0,3,0,2] and [0,3,1,2] are accepted answers.
 * [0,2,4,2] is equivalent to ["ATL","LAX","HND","LAX"] which has edit distance = 1 with targetPath.
 * [0,3,0,2] is equivalent to ["ATL","DXB","ATL","LAX"] which has edit distance = 1 with targetPath.
 * [0,3,1,2] is equivalent to ["ATL","DXB","PEK","LAX"] which has edit distance = 1 with targetPath.
 *
 * Example 2:
 * Input: n = 6, roads = [[0,1],[1,2],[2,3],[3,4],[4,5]], names = ["ATL","PEK","LAX","ATL","DXB","HND"], targetPath = ["ATL","DXB","HND","DXB","ATL","LAX","PEK"]
 * Output: [3,4,5,4,3,2,1]
 * Explanation: [3,4,5,4,3,2,1] is the only path with edit distance = 0 with targetPath.
 * It's equivalent to ["ATL","DXB","HND","DXB","ATL","LAX","PEK"]
 *
 * Example 3:
 * Input: n = 4, roads = [[1,0],[2,0],[3,0],[2,1],[3,1],[3,2]], names = ["ATL","PEK","LAX","DXB"], targetPath = ["ABC","DEF","GHI","JKL","MNO","PQR","STU","VWX"]
 * Output: [0,1,0,1,0,1,0,1]
 * Explanation: Any path in this graph has edit distance = 8 with targetPath.
 */
public class MostSimilarPathInGraphG {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int[][] path = new int[n][n];
        Result dp[][] = new Result[n][targetPath.length+1];
        for (int i=0;i<roads.length;i++){
            path[roads[i][0]][roads[i][1]] = 1;
            path[roads[i][1]][roads[i][0]] = 1;
        }
        Result minDist = null;
        for (int i=0;i<n;i++){
            Result dis = dfs(targetPath.length,i,path,names,targetPath,dp);
            if (minDist == null || minDist.editDist > dis.editDist)
                minDist = dis;
        }
        return minDist.path;
    }

    public Result dfs(int pathLeft,int city,int [][]path,String []names,String []targetPath,Result dp[][]){
        if (pathLeft == 0){
            return null;
        }

        Result result = new Result(Integer.MAX_VALUE,new LinkedList<>());
        result.editDist =  editDist(targetPath,names,pathLeft,city);
        result.path.add(city);

        int cities[] = path[city];
        Result mindDist = new Result(Integer.MAX_VALUE,null);
        for (int j=0;j<cities.length;j++){
            if (path[city][j] == 0)
                continue;

            Result remainDist;
            if (dp[j][pathLeft-1] != null)
                remainDist = dp[j][pathLeft-1];
            else
                remainDist = dfs(pathLeft - 1,j,path,names,targetPath,dp);
            if (remainDist != null && remainDist.editDist < mindDist.editDist)
                mindDist = remainDist;
        }

        if (mindDist.editDist != Integer.MAX_VALUE) {
            result.editDist += mindDist.editDist;
            result.path.addAll(mindDist.path);
        }
        dp[city][pathLeft] = result;
        return result;
    }

    public int editDist(String []targetPath,String []names,int path,int city){
        if (!targetPath[targetPath.length - path].equals(names[city]))
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        MostSimilarPathInGraphG obj = new MostSimilarPathInGraphG();
        int n = 5;
        int[][] roads = {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}};
        String[] names = {"ATL","PEK","LAX","DXB","HND"};
        String[] targetPath = {"ATL","DXB","HND","LAX"};

        List<Integer> result = obj.mostSimilar(n,roads,names,targetPath);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
class Result {
    int editDist;
    List<Integer> path;
    public Result(int editDis,List<Integer> path){
        this.editDist = editDis;
        this.path = path;
    }
}
