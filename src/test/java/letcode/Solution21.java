package letcode;

/**
 * @author CarryJey
 * @since 2018/12/12
 */
public class Solution21 {
    /**
     * 合并两个链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }
        if (l2 == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode tail = res;
        while (l1.next != null && l2.next != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if (l1.next != null) {
            tail.next = l1;
        }
        if (l2.next != null) {
            tail.next = l2;
        }
        return res.next;
    }
}
