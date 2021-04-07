package linkedList;

public class DoTerminatedListsOverlap {
    public static void main (String [] args) {
        SingleListNode<Integer> L2 = new SingleListNode(3,new SingleListNode(4,new SingleListNode(5,new SingleListNode(6,new SingleListNode(7,new SingleListNode(8,null))))));
        SingleListNode<Integer> L0 = new SingleListNode(1,new SingleListNode(2,L2));
        SingleListNode<Integer> L1 = new SingleListNode(11,new SingleListNode(12,L2));
        SingleListNode<Integer> commonNode = overlappingNoCycleLists(L0,L1);
        System.out.println(commonNode.data);
    }
    public static SingleListNode<Integer> overlappingNoCycleLists (SingleListNode<Integer> l0, SingleListNode<Integer> l1) {
        int l0Length = length(l0);
        int l1length = length(l1);
        //Advance longer list to get equal length list
        if(l0Length > l1length){
            l0 = advanceListByK(l0Length-l1length,l0);
        } else {
            l1 = advanceListByK(l1length-l0Length,l1);
        }
        while(l0 != null && l1 != null && l0 != l1) {
            l0 = l0.next;
            l1 = l1.next;
        }
        return l0;
    }
    private static SingleListNode<Integer> advanceListByK(int k, SingleListNode<Integer> l) {
        while(k-- > 0) {
            l = l.next;
        }
        return l;
    }
    private static int length(SingleListNode<Integer> l) {
        int length = 0;
        while(l != null) {
            l = l.next;
            length ++;
        }
        return length;
    }
}
