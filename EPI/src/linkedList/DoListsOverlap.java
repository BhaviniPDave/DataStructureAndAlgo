package linkedList;

public class DoListsOverlap {

    public static SingleListNode<Integer> overLappingLists(SingleListNode<Integer> l0,SingleListNode<Integer> l1) {
        SingleListNode<Integer> root0 = IsListCyclic.hasCycle(l0);
        SingleListNode<Integer> root1 = IsListCyclic.hasCycle(l1);
        if(root0  == null && root1 == null) {
            //Both Lists don't have cycle
            return DoTerminatedListsOverlap.overlappingNoCycleLists(l0,l1);
        } else if ((root0 != null && root1 == null) || (root0 == null && root1 != null)) {
            //One of the list has cycle.
            return null;
        }
        //Both Lists have cycle.
        SingleListNode<Integer> temp = root1;
        do {
            temp = temp.next;
        }while (temp != root0 && temp != root1);
        return temp == root0 ? root1 : null;
    }
}
