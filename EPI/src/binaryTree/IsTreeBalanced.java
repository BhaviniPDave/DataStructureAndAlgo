package binaryTree;

public class IsTreeBalanced {
    private static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(BinaryTreeNode<Character> root) {
        return checkBalanced(root).balanced;
    }

    private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Character> root) {
        if (root == null)
            return new BalanceStatusWithHeight(true, -1);
        BalanceStatusWithHeight leftResult = checkBalanced(root.left);
        if (!leftResult.balanced)
            return leftResult;
        BalanceStatusWithHeight rightResult = checkBalanced(root.right);
        if (!rightResult.balanced)
            return rightResult;
        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }

    public static void main(String[] args) {
        BinaryTreeNode E = new BinaryTreeNode('E', null, null);
        BinaryTreeNode F = new BinaryTreeNode('F', null, null);
        BinaryTreeNode D = new BinaryTreeNode('D', E, F);
        BinaryTreeNode G = new BinaryTreeNode('G', null, null);
        BinaryTreeNode C = new BinaryTreeNode('C', D, G);
//        BinaryTreeNode I = new BinaryTreeNode('I', null, null);
//        BinaryTreeNode J = new BinaryTreeNode('J', null, null);
        BinaryTreeNode H = new BinaryTreeNode('H', null, null);
        BinaryTreeNode B = new BinaryTreeNode('B', C, H);
        BinaryTreeNode M = new BinaryTreeNode('M', null, null);
        BinaryTreeNode N = new BinaryTreeNode('N', null, null);
        BinaryTreeNode L = new BinaryTreeNode('L', M, N);
        BinaryTreeNode O = new BinaryTreeNode('O', null, null);
        BinaryTreeNode K = new BinaryTreeNode('K', L, O);
        BinaryTreeNode A = new BinaryTreeNode('A', B, K);

        System.out.println(IsTreeBalanced.isBalanced(A));

    }
}
