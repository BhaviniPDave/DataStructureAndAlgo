package linkedList;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;
    public ListNode(T data, ListNode<T> next) {
        this.data =data;
        this.next = next;
    }

    public static ListNode<Integer> searchList(ListNode<Integer> L, int key) {
        while (L != null && L.data != key){
            L = L.next;
        }
        //If key is not present L will become null
        return L;
    }

    public static void insertAfter (ListNode<Integer> node, ListNode<Integer> newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    public static void deleteList(ListNode<Integer> node) {
        //Assumes node is not tail
        node.next = node.next.next;
    }
}
