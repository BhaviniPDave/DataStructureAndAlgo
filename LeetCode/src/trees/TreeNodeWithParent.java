package trees;

public class TreeNodeWithParent<T> {
    T val;
    TreeNodeWithParent left;
    TreeNodeWithParent right;
    TreeNodeWithParent parent;
    TreeNodeWithParent() {}
    TreeNodeWithParent(T val) { this.val = val; }
    TreeNodeWithParent(T val, TreeNodeWithParent left, TreeNodeWithParent right,TreeNodeWithParent parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
