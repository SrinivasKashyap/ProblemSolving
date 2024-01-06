package LinkedLists;

public class leetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode curr = null;
        ListNode root = null;
        if (i == null) return j;
        if (j == null) return i;
        if (i.val < j.val) {
            curr = i;
            root = i;
            i = i.next;
        } else {
            curr = j;
            root = j;
            j = j.next;
        }

        while (null != i && null != j) {
            if (i.val < j.val) {
                curr.next = i;
                i = i.next;
            } else {
                curr.next = j;
                j = j.next;
            }
            curr = curr.next;
        }
        while (null != i) {
            curr.next = i;
            i = i.next;
            curr = curr.next;
        }
        while (null != j) {
            curr.next = j;
            j = j.next;
            curr = curr.next;
        }
        return root;
    }
}
