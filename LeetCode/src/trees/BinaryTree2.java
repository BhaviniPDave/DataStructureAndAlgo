package trees;

public class BinaryTree2 {

    public TreeNode getTree(){
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");
        TreeNode L = new TreeNode("L");
        TreeNode M = new TreeNode("M");
        TreeNode N = new TreeNode("N");
        TreeNode O = new TreeNode("O");
        TreeNode P = new TreeNode("P");

        A.left = B;
        A.right = I;

        B.left = C;
        B.right = F;

        C.left = D;
        C.right = E;

        F.right = G;
        G.left = H;

        I.left = J;
        I.right = O;

        J.right = K;
        K.left = L;
        K.right = N;
        L.right = M;

        O.right = P;

        return A;
    }
}
