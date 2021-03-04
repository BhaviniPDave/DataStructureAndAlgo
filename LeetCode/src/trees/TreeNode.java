package trees;

public class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(T val) { this.val = val; }
    TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
