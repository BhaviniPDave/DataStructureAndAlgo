package linkedList;

public class ReverseKSubLists {
    public static SingleListNode<Integer> reverseKSubList(SingleListNode<Integer> head, int k)
    {
        if(head == null)
            return null;
        SingleListNode current = head;
        SingleListNode next = null;
        SingleListNode prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverseKSubList(next, k);

        // prev is now head of input list
        return prev;
    }
}
