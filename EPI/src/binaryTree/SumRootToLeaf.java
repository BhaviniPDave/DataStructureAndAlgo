package binaryTree;

public class SumRootToLeaf {
    public static int sumRootToLeaf(BinaryTreeNode<Integer> root) {
        return sumRootToLeafHelper(root,0);
    }
    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> root, int partialPathSum) {
        if(root == null) {
            return 0;
        }
        partialPathSum = partialPathSum * 2 + root.data;
        if(root.left == null  && root.right == null) {
            //Leaf
            return partialPathSum;
        }
        //Non Leaf
        return sumRootToLeafHelper(root.left,partialPathSum) + sumRootToLeafHelper(root.right,partialPathSum);
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

        System.out.print(sumRootToLeaf(A));
    }
}
