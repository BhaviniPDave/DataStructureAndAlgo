package linkedList;

public class SortedListsMerge {
    public static void main (String[] args) {
        SingleListNode L1 = new SingleListNode(2,new SingleListNode(5,new SingleListNode(7,null)));
        SingleListNode L2 = new SingleListNode(3,new SingleListNode(11, null));
        SingleListNode mergedList = mergeTwoSortedLists(L1,L2);
        while (mergedList != null) {
            System.out.print(mergedList.data + "->");
            mergedList = mergedList.next;
        }
    }
    public static SingleListNode<Integer> mergeTwoSortedLists(SingleListNode<Integer> L1, SingleListNode<Integer> L2) {
        //Creates a placeholder for the list
        SingleListNode<Integer> dummyHead = new SingleListNode(0, null);
        SingleListNode<Integer> current = dummyHead;
        while (L1 != null && L2 != null) {
            if (L1.data <= L2.data) {
                current.next = L1;
                L1 = L1.next;
            }
            else {
                current.next = L2;
                L2 = L2.next;
            }
            current = current.next;
        }
        //Appends the remaiing nodes of L1 or L2
        current.next = L1 != null ? L1 : L2;
        return dummyHead.next;
    }
}
