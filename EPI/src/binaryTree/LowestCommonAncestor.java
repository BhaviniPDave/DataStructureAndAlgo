package binaryTree;

public class LowestCommonAncestor {

    private static class Status {
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;
        public Status (int numTargetNodes, BinaryTreeNode<Integer> ancestor){
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode<Integer> lca (BinaryTreeNode<Integer> root,
                                               BinaryTreeNode<Integer> node0,
                                               BinaryTreeNode<Integer> node1){
        return lcaHelper(root,node0,node1).ancestor;
    }

    private static Status lcaHelper(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node0,
                                    BinaryTreeNode<Integer> node1){
        if(root == null)
            return new Status(0,null);

        Status leftResult = lcaHelper(root.left,node0,node1);
        if(leftResult.numTargetNodes == 2) {
            //Found both nodes in the left subtree
            return leftResult;
        }
        Status rightResult = lcaHelper(root.right,node0,node1);
        if(rightResult.numTargetNodes == 2) {
            //Found both nodes in right sub tree
            return rightResult;
        }

        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes +
                (root == node0 ?1 :0) + (root == node1?1:0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? root :null);

    }

    public static void main(String[] args) {
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

        BinaryTreeNode<Integer> lca = lca(A,M,N);
        System.out.print(lca.data);
    }

}
