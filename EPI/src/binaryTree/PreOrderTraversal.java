package binaryTree;

public class PreOrderTraversal {
    public static void preOrderTraversalRecursion(BinaryTreeNode<Character> root ){
        System.out.print(root.data);
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode N = new BinaryTreeNode('N',null,null);
        BinaryTreeNode H = new BinaryTreeNode('H',null,null);
        BinaryTreeNode D = new BinaryTreeNode('D',null,null);
        BinaryTreeNode E = new BinaryTreeNode('E',null,null);
        BinaryTreeNode P = new BinaryTreeNode('P',null,null);
        BinaryTreeNode M = new BinaryTreeNode('M',null,null);
        BinaryTreeNode C = new BinaryTreeNode('C',D,E);
        BinaryTreeNode G = new BinaryTreeNode('G',H,null);
        BinaryTreeNode F = new BinaryTreeNode('F',null,G);
        BinaryTreeNode B = new BinaryTreeNode('B',C,F);
        BinaryTreeNode L = new BinaryTreeNode('L',null,M);
        BinaryTreeNode K = new BinaryTreeNode('K',L,N);
        BinaryTreeNode O = new BinaryTreeNode('O',null,P);
        BinaryTreeNode J = new BinaryTreeNode('J',null,K);
        BinaryTreeNode I = new BinaryTreeNode('I',J,O);
        BinaryTreeNode A = new BinaryTreeNode('A',B,I);

        preOrderTraversalRecursion(A);

    }
}
