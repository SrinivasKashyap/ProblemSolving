package LinkedList;

class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return util(null, head);
    }
    public ListNode util(ListNode prev, ListNode curr) {
        if (null == curr) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return util(prev, curr);
    }
}