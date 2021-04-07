package linkedList;

public class IsListCyclic {
    public static void main (String [] args) {
        SingleListNode<Integer> L7 = new SingleListNode(7,null);
        SingleListNode<Integer> L6 = new SingleListNode(6,L7);
        SingleListNode<Integer> L5 = new SingleListNode(5,L6);
        SingleListNode<Integer> L4 = new SingleListNode(4,L5);
        SingleListNode<Integer> L3 = new SingleListNode(3,L4);
        SingleListNode<Integer> L2 = new SingleListNode(2,L3);
        SingleListNode<Integer> L1 = new SingleListNode(1,L2);
        L7.next = L3;
        SingleListNode cycleStartNode = hasCycle(L1);
        System.out.println(cycleStartNode.data);
    }
    public static SingleListNode<Integer> hasCycle(SingleListNode<Integer> head) {
         SingleListNode<Integer> fast =head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                //Cycle detected
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; //Or return fast, both are pointing to same node
            }
        }
        return null;
    }
}
