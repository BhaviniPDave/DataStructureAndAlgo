package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathsWithGivenSum {
    public static List<List<Integer>> showAllPaths(BinaryTreeNode<Integer> root, int sum){
        List<List<Integer>> allPathsList = new ArrayList<>();
        List<Integer> singlePath = new ArrayList<>();
        sumPathHelper(root,sum,allPathsList,singlePath);
        return allPathsList;
    }
    private static void sumPathHelper(BinaryTreeNode<Integer> root, int sum, List<List<Integer>> allPathsList, List<Integer> singlePath) {
        if(root == null) {
            return;
        }
        singlePath.add(root.data);
        if(root.left == null && root.right == null && root.data == sum){
            //Leaf node and sum matches target
            allPathsList.add(new ArrayList<>(singlePath));
        }
        else {
            sumPathHelper(root.left,sum -root.data,allPathsList,singlePath );
            sumPathHelper(root.right,sum -root.data,allPathsList,singlePath );
        }
        singlePath.remove(singlePath.size() - 1);
    }
    public static void main (String[] args) {
        BinaryTreeNode N = new BinaryTreeNode(257,null,null);
        BinaryTreeNode H = new BinaryTreeNode(17,null,null);
        BinaryTreeNode D = new BinaryTreeNode(28,null,null);
        BinaryTreeNode E = new BinaryTreeNode(0,null,null);
        BinaryTreeNode P = new BinaryTreeNode(28,null,null);
        BinaryTreeNode M = new BinaryTreeNode(641,null,null);
        BinaryTreeNode C = new BinaryTreeNode(271,D,E);
        BinaryTreeNode G = new BinaryTreeNode(3,H,null);
        BinaryTreeNode F = new BinaryTreeNode(561,null,G);
        BinaryTreeNode B = new BinaryTreeNode(6,C,F);
        BinaryTreeNode L = new BinaryTreeNode(401,null,M);
        BinaryTreeNode K = new BinaryTreeNode(1,L,N);
        BinaryTreeNode O = new BinaryTreeNode(271,null,P);
        BinaryTreeNode J = new BinaryTreeNode(2,null,K);
        BinaryTreeNode I = new BinaryTreeNode(6,J,O);
        BinaryTreeNode A = new BinaryTreeNode(314,B,I);

        List<List<Integer>> result = showAllPaths(A,619);
        System.out.print(result);
    }
}
