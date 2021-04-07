package linkedList;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodes {
    public static void main (String[] args) {
        ListNode L1 = new ListNode(11,new ListNode(3,new ListNode(5,new ListNode(7,new ListNode(2,new ListNode(14,null))))));
        ListNode L2 = new ListNode(11,null);
        ListNode swapedList = swapPairs2(L1);
        while (swapedList != null) {
            System.out.print(swapedList.data + "->");
            swapedList = swapedList.next;
        }
    }
    public static ListNode<Integer> swapPairs2(ListNode<Integer> head) {
        ListNode<Integer> newHead = head, working = head;
        ListNode<Integer> next = null;

        while(working!=null && working.next!=null){
            ListNode<Integer> temp = working.next;
            if(next!=null)
                next.next= temp;
            working.next = temp.next;
            temp.next = working;
            next=working;
            working = working.next;
            if(newHead == head){
                newHead = temp;
            }
        }
        return newHead;
    }
    public static ListNode<Integer> swapPairs (ListNode<Integer> head) {
        if (head == null){
            return null;
        }
        if (head.next == null)
            return head;
        ListNode<Integer> finalHead = head.next;
        ListNode<Integer> prev = head;
        ListNode<Integer> curr = head.next;
        ListNode<Integer> third = null;
        while (curr != null) {
            third = curr.next;
            curr.next = prev;
            if (third != null && third.next != null) {
                prev.next = third.next;
                curr = third.next;
            }
            else if(third == null){
                prev.next = third;
                curr = third;
            }
            prev = third;
        }
        return finalHead;
    }
}
