public class mergeTwoSortedLists {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = list1;
        if (null == list1 && null == list2) return curr; 
        else if (null == list2) {
            curr = list1;
            list1 = list1.next;
        } else if (null == list1) {
            curr = list2;
            list2 = list2.next;
        } else if (list1.val > list2.val) {
            curr = list2;
            list2 = list2.next;
        } else {
            list1 = list1.next;
        }
        util(curr, list1, list2);
        return curr;
    }
    public void util(ListNode curr, ListNode list1, ListNode list2) {
        if (null == list1 && null == list2) return; 
        else if (null == list2) {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        } else if (null == list1) {
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        } else if (list1.val > list2.val) {
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        } else {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;  
        }
        util(curr, list1, list2);
    }
}
