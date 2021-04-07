package linkedList;

public class ReverseSubList {
    private static boolean stop;
    private static SingleListNode<Integer> left;

    public static void main (String[] args) {
        SingleListNode L1 = new SingleListNode(11,new SingleListNode(3,new SingleListNode(5,new SingleListNode(7,new SingleListNode(2,new SingleListNode(14,null))))));
        SingleListNode mergedList = reverseSubList(L1,1,4);
        while (mergedList != null) {
            System.out.print(mergedList.data + "->");
            mergedList = mergedList.next;
        }
    }
    public static SingleListNode<Integer> reverseSubList(SingleListNode<Integer> head, int start, int end) {
        left = head;
        stop = false;
        recurseAndReverse(head, start,end);
        return head;
    }
    public static void recurseAndReverse(SingleListNode<Integer> right, int m, int n) {
        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            left = left.next;
        }

        // Recurse with m and n reduced.
        recurseAndReverse(right, m - 1, n - 1);
        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (left == right || right.next == left) {
            stop = true;
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!stop) {
            Integer t = left.data;
            left.data = right.data;
            right.data = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            left = left.next;
        }
    }
    public static SingleListNode<Integer> reverseSubListIterative(SingleListNode<Integer> L, int start, int finish) {
        SingleListNode<Integer> dummyHead = new SingleListNode<>(0,L);
        SingleListNode<Integer> sublistHead = dummyHead;
        int k =1;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }
        //Reverse sublist
        SingleListNode<Integer> subListIter = sublistHead.next;
        while (start++ < finish) {
            SingleListNode<Integer> temp = subListIter.next;
            subListIter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }

    /**
     * Approach 2: Iterative Link Reversal.
     * Intuition
     *
     * In the previous approach, we looked at an algorithm for reversing a portion of the given linked list such that the underlying structure doesn't change. We only modified the values of the nodes for achieving the reversal. However, it may so happen that you cannot change the data available in the nodes. In that scenario, we have to modify the links themselves to achieve the reversal.
     *
     * Essentially, starting from the node at position m and all the way up to n, we reverse the next pointers for all the nodes in between. Let's look at the algorithm for achieving this.
     *
     * Algorithm
     *
     * Before looking at the algorithm, it's important to understand how the link reversal will work and what set of pointers will be required for the same. Let's say we have a linked list consisting of three different nodes, A → B → C and we want to reverse the links between the nodes and obtain A ← B ← C.
     *
     * Suppose we have at our disposal, two pointers. One of them points to the node A and the other one points to the node B. Let's call these pointers prev and cur respectively. We can simply use these two pointers to reverse the link between A and B.
     *
     * cur.next = prev
     * The only problem with this is, we don't have a way of progressing further i.e. once we do this, we can't reach the node C. That's why we need a third pointer that will help us continue the link reversal process. So, we do the following instead.
     *
     * third = cur.next
     * cur.next = prev
     * prev = cur
     * cur = third
     * We do the above iteratively and we will achieve what the question asks us to do. Let's look at the steps for the algorithm now.
     *
     * We need two pointers, prev and cur as explained above.
     *
     * The prev pointer should be initialized to None initially while cur is initialized to the head of the linked list.
     *
     * We progress the cur pointer one step at a time and the prev pointer follows it.
     *
     * We keep progressing the two pointers in this way until the cur pointer reaches the m^{th}m
     * th
     *   node from the beginning of the list. This is the point from where we start reversing our linked list.
     *
     * An important thing to note here is the usage of two additional pointers which we will call as tail and con. The tail pointer points to the m^{th}m
     * th
     *   node from the beginning of the linked list and we call it a tail pointer since this node becomes the tail of the reverse sublist. The con points to the node one before m^{th}m
     * th
     *   node and this connects to the new head of the reversed sublist. Let's take a look at a figure to understand these two pointers better.
     *
     *
     * The tail and the con pointers are set once initially and then used in the end to finish the linked list reversal.
     *
     * Once we reach the m^{th}m
     * th
     *   node, we iteratively reverse the links as explained before using the two pointers. We keep on doing this until we are done reversing the link (next pointer) for the n^{th}n
     * th
     *   node. At that point, the prev pointer would point to the n^{th}n
     * th
     *   node.
     *
     * We use the con pointer to attach to the prev pointer since the node now pointed to by the prev pointer (the n^{th}n
     * th
     *   node from the beginning) will come in place of the m^{th}m
     * th
     *   node due after the reversal. Similarly, we will make use of the tail pointer to connect to the node next to the prev node i.e. (n+1)^{th}(n+1)
     * th
     *   node from the beginning.
     *
     * Let's have a look at the algorithm execute on a sample linked list to make the use case for all these pointers clearer. We are given a linked list initially with elements 7 → 9 → 2 → 10 → 1 → 8 → 6 and we need to reverse the list from node 3 through 6.
     * We can see the first few steps of our iterative solution above. The first step shows the initialization of the two pointers and the third step shows us the starting point for the list reversal process.
     * This shows us in detail how the links are reversed and how we move forward after reversing the links between two nodes. This step is done multiple times as shown in the following images.
     * As we can see from the above images, now the two pointers have reached their final positions. We are done reversing the sublist that we were required to do i.e. nodes 3 through 6. However, we still have to fix some connections. The next image explains how we use the tail and con pointers to make the final connections.
     *
     * https://leetcode.com/problems/reverse-linked-list-ii/solution/
     *
     * @param head
     * @param start
     * @param end
     * @return
     */
    public static SingleListNode<Integer> reverseBetween (SingleListNode<Integer> head, int start , int end) {
        //Empty List
        if(head == null) {
            return null;
        }
        //move the two pointer until they reach starting point
        SingleListNode<Integer> curr = head;
        SingleListNode<Integer> prev = null;
        while (start > 1) {
            prev = curr;
            curr = curr.next;
            start --;
            end --;
        }
        //The two pointer that will fix final pointers
        SingleListNode<Integer> con = prev;
        SingleListNode<Integer> tail = curr;

        //Iteratively reverse nodes until end becomes 0
        SingleListNode<Integer> third = null;
        while (end > 0) {
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            end --;
        }
        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = curr;
        return head;
    }

}
