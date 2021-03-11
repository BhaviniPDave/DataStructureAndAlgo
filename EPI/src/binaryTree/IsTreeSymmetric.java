package binaryTree;

public class IsTreeSymmetric {
    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return root == null || checkSymmetric(root.left,root.right);
    }
    private static boolean checkSymmetric(BinaryTreeNode<Integer> root0,BinaryTreeNode<Integer> root1) {
        if(root0 == null && root1 == null)
            return true;
        else if(root0 != null && root1 != null) {
            return root0.data == root1.data &&
                    checkSymmetric(root0.left,root1.right) ||
                    checkSymmetric(root0.right,root1.left);


        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode D = new BinaryTreeNode(3, null, null);
        BinaryTreeNode G = new BinaryTreeNode(3, null, null);

        BinaryTreeNode C = new BinaryTreeNode(2, null, D);
        BinaryTreeNode F = new BinaryTreeNode(2, G, null);

        BinaryTreeNode B = new BinaryTreeNode(6, null, C);
        BinaryTreeNode E = new BinaryTreeNode(6, F, null);

        BinaryTreeNode A = new BinaryTreeNode(314, B, E);

        System.out.print(IsTreeSymmetric.isSymmetric(A));

    }
}
