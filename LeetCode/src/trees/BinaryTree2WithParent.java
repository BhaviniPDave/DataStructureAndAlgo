package trees;

public class BinaryTree2WithParent {

    public TreeNodeWithParent getTree(){
        TreeNodeWithParent A = new TreeNodeWithParent("A");
        TreeNodeWithParent B = new TreeNodeWithParent("B");
        TreeNodeWithParent C = new TreeNodeWithParent("C");
        TreeNodeWithParent D = new TreeNodeWithParent("D");
        TreeNodeWithParent E = new TreeNodeWithParent("E");
        TreeNodeWithParent F = new TreeNodeWithParent("F");
        TreeNodeWithParent G = new TreeNodeWithParent("G");
        TreeNodeWithParent H = new TreeNodeWithParent("H");
        TreeNodeWithParent I = new TreeNodeWithParent("I");
        TreeNodeWithParent J = new TreeNodeWithParent("J");
        TreeNodeWithParent K = new TreeNodeWithParent("K");
        TreeNodeWithParent L = new TreeNodeWithParent("L");
        TreeNodeWithParent M = new TreeNodeWithParent("M");
        TreeNodeWithParent N = new TreeNodeWithParent("N");
        TreeNodeWithParent O = new TreeNodeWithParent("O");
        TreeNodeWithParent P = new TreeNodeWithParent("P");

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

        A.parent = null;
        B.parent = A;
        C.parent = B;
        D.parent = C;
        E.parent = C;
        F.parent = B;
        G.parent = F;
        H.parent = G;
        I.parent = A;
        J.parent = I;
        K.parent = J;
        L.parent = K;
        M.parent = L;
        N.parent = K;
        O.parent = I;
        P.parent = O;

        return A;
    }
}
