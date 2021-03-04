package trees;

import java.util.Stack;

public class InOrderTraversal {

    public static void inOrderWithRecursion (TreeNode root){
        if(root != null){
            inOrderWithRecursion(root.left);
            System.out.print(root.val + " , ");
            inOrderWithRecursion(root.right);
        }
    }

    public static void inOrderWithoutRecursion (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //curr is null now
            curr = stack.pop();
            System.out.print(curr.val +" , ");
            curr = curr.right;
        }
    }

    /**
     *
     * Assume each node maintains parent
     * @param root
     */
    public static void inOrderWithConstantSpaceWithoutRecursion (TreeNodeWithParent root) {
        TreeNodeWithParent prev = null;
        TreeNodeWithParent curr = root;

        while (curr != null) {
            TreeNodeWithParent next;
            if(curr.parent == prev) { //We Came down to curr from prev
                if(curr.left != null){ //Keep Going Left
                    next = curr.left;
                }
                else {
                    System.out.print(curr.val + " , ");
                    //Done with left, so go right
                    //If right is empty then go to parent
                    next = (curr.right != null)?curr.right: curr.parent;
                }
            }
            else if (curr.left == prev) {
                System.out.print(curr.val + " , ");
                //Done with left, so go right
                //If right is empty then go to parent
                next = (curr.right != null)?curr.right: curr.parent;
            }
            else {
                //Done with both children so move up
                next = curr.parent;
            }
            prev = curr;
            curr = next;
        }
    }

    public static void inOrderWithConstantSpaceWithoutRecursion (TreeNode root) {
        TreeNode curr,prev;
        if(root == null)
            return;
        curr = root;
        while (curr != null) {
            if(curr.left == null) {
                System.out.print(curr.val + " , "); //Print root and move to right
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    System.out.print(curr.val+ " , ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main (String[] args) {
        TreeNode root1 = new BinaryTree2().getTree();
        inOrderWithRecursion(root1);
        System.out.println();

        inOrderWithoutRecursion(root1);
        System.out.println();

        inOrderWithConstantSpaceWithoutRecursion(root1);
        System.out.println();

        TreeNodeWithParent root2 = new BinaryTree2WithParent().getTree();
        inOrderWithConstantSpaceWithoutRecursion(root2);
    }
}
