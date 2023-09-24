package LinkedList;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */

public class swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode tempnext = new ListNode(head.val);
        ListNode temp = new ListNode(head.next.val, tempnext);
        if (null != head.next.next) tempnext.next = swapPairs(head.next.next);
        return temp;
    }
}
