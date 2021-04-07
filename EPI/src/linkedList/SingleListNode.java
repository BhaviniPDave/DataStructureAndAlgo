package linkedList;

public class SingleListNode<T> {
    public T data;
    public SingleListNode<T> next;
    public SingleListNode(T data, SingleListNode<T> next) {
        this.data =data;
        this.next = next;
    }

    public static SingleListNode<Integer> searchList(SingleListNode<Integer> L,int key) {
        while (L != null && L.data != key){
            L = L.next;
        }
        //If key is not present L will become null
        return L;
    }

    public static void insertAfter (SingleListNode<Integer> node, SingleListNode<Integer> newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    public static void deleteList(SingleListNode<Integer> node) {
        //Assumes node is not tail
        node.next = node.next.next;
    }
}
