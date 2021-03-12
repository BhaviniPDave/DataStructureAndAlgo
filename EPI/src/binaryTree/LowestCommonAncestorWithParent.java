package binaryTree;

public class LowestCommonAncestorWithParent {

    public static BinaryTree<Integer> lca (BinaryTree<Integer> node0,
                                           BinaryTree<Integer> node1) {
        int depth0 = getDepth(node0);
        int depth1 = getDepth(node1);
        //Makes Node 0 to simplify code
        if (depth1 > depth0) {
           BinaryTree<Integer> temp = node1;
            node1 = node0;
            node0 = temp;
        }
        int depthDiff = Math.abs(depth0 - depth1);
        while(depthDiff -- > 0) {
            node0 = node0.parent;
        }
        //Now move both nodes in same order
        while(node0 == node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0;
    }
    private static int getDepth(BinaryTree<Integer> root) {
        int depth = 0;
        while (root.parent != null){
            ++depth;
            root = root.parent;
        }
        return depth;
    }
}
