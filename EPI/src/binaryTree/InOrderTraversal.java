package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void inOrderTraversalRecursion(BinaryTreeNode<Integer> root ){
        if(root == null)
            return;

        inOrderTraversalRecursion(root.left);
        System.out.print(root.data +" ");
        inOrderTraversalRecursion(root.right);
    }

    public static List<Integer> inOrderTraversalIterative(BinaryTreeNode<Integer> root){
        List<Integer> inOrderTraversal = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = root;
        while (!stack.isEmpty() || curr != null){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //Curr is null at this point
            curr = stack.pop();
            inOrderTraversal.add((Integer) curr.data);
            curr = curr.right;
        }
        return inOrderTraversal;
    }

    public static void inOrderTraversalIterativeWithoutSpace(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> curr, prev;
        if(root == null)
            return;
        curr = root;
        while(curr != null) {
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main (String[] args) {
        BinaryTreeNode N = new BinaryTreeNode(257,null,null);
        BinaryTreeNode H = new BinaryTreeNode(17,null,null);
        BinaryTreeNode D = new BinaryTreeNode(28,null,null);
        BinaryTreeNode E = new BinaryTreeNode(0,null,null);
        BinaryTreeNode P = new BinaryTreeNode(28,null,null);
        BinaryTreeNode M = new BinaryTreeNode(641,null,null);
        BinaryTreeNode C = new BinaryTreeNode(271,D,E);
        BinaryTreeNode G = new BinaryTreeNode(3,H,null);
        BinaryTreeNode F = new BinaryTreeNode(561,null,G);
        BinaryTreeNode B = new BinaryTreeNode(6,C,F);
        BinaryTreeNode L = new BinaryTreeNode(401,null,M);
        BinaryTreeNode K = new BinaryTreeNode(1,L,N);
        BinaryTreeNode O = new BinaryTreeNode(271,null,P);
        BinaryTreeNode J = new BinaryTreeNode(2,null,K);
        BinaryTreeNode I = new BinaryTreeNode(6,J,O);
        BinaryTreeNode A = new BinaryTreeNode(314,B,I);
        inOrderTraversalRecursion(A);
        System.out.println(inOrderTraversalIterative(A));
        System.out.println();
        inOrderTraversalIterativeWithoutSpace(A);
    }
}
