package trees;

import java.util.Stack;

public class PreOrderTraversal {

    public static void preOrderWithRecursion (TreeNode root){
        if(root != null){
            System.out.print(root.val + " , ");
            preOrderWithRecursion(root.left);
            preOrderWithRecursion(root.right);
        }
    }

    public static void preOrderWithoutRecursion (TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " , ");
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void main (String[] args) {
        TreeNode root1 = new BinaryTree2().getTree();
        preOrderWithRecursion(root1);
        System.out.println();

        preOrderWithoutRecursion(root1);
        System.out.println();
    }
}
