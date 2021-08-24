package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimilarPathInAGraphG2 {
    List<List<Integer>> adjMatrix;
    String[] names;
    String[] targetPath;
    int[][] visited;
    int[][] nextChoiceForMin;
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        this.visited = new int[names.length][targetPath.length];
        this.nextChoiceForMin = new int[names.length][targetPath.length];
        this.targetPath = targetPath;
        this.names = names;
        this.adjMatrix = new ArrayList<>();

        for(int[] x: visited) {
            Arrays.fill(x, -1);
        }
        //BUild Matrix
        for(int i = 0;i<n;i++) {
            adjMatrix.add(new ArrayList<Integer>());
        }
        for(int[] road: roads) {
            adjMatrix.get(road[0]).add(road[1]);
            adjMatrix.get(road[1]).add(road[0]);
        }

        // From each node, calculate min cost and the city that gave the min cost.
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int i=0;i<names.length;i++) {
            int resp = dfs(i,0);
            if(resp < min){
                resp = min;
                start = i;
            }
        }

        //Build the answer based on what's next best choice
        List<Integer> ans = new ArrayList<>();
        while(ans.size() < targetPath.length){
            ans.add(start);
            start = nextChoiceForMin[start][ans.size() - 1];
        }
        return ans;
    }

    private int dfs (int namesIndex, int currPathIndex) {
        // If visited already, return previous count
        if(visited[namesIndex][currPathIndex] != -1){
            return visited[namesIndex][currPathIndex];
        }

        //If it's different add 1 else add 0
        int editDistance = (names[namesIndex].equals(targetPath[currPathIndex]))? 0 : 1;

        //If we have filled up path, we are done
        if(currPathIndex == targetPath.length -1)
            return editDistance;

        int min = Integer.MAX_VALUE;
        for(int neighbour: adjMatrix.get(namesIndex)) {
            int neighbourCost = dfs(neighbour, currPathIndex + 1);
            if(neighbourCost < min) {
                neighbourCost = min;
                nextChoiceForMin[namesIndex][currPathIndex] = neighbour;
            }
        }

        editDistance += min;
        visited[namesIndex][currPathIndex] = editDistance;
        return editDistance;
    }
    public static void main (String[] args) {
        SimilarPathInAGraphG2 obj  = new SimilarPathInAGraphG2();
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
