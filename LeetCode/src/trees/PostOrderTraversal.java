package trees;

import java.util.Stack;

public class PostOrderTraversal {

    public static void postOrderWithRecursion (TreeNode root){
        if(root != null){
            postOrderWithRecursion(root.left);
            postOrderWithRecursion(root.right);
            System.out.print(root.val + " , ");
        }
    }

    public static void postOrderWithoutRecursion (TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if(temp.left != null) {
                stack1.push(temp.left);
            }

            if(temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " , ");
        }
    }

    public static void main (String[] args) {
        TreeNode root1 = new BinaryTree2().getTree();
        postOrderWithRecursion(root1);
        System.out.println();

        postOrderWithoutRecursion(root1);
        System.out.println();
    }
}
