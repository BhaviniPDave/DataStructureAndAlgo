package binaryTree;

public class BinaryTree<T>{
    public T data;
    public BinaryTree<T> parent;
    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(T data, BinaryTree<T> parent, BinaryTree<T> left, BinaryTree<T> right){
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
