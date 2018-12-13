package letcode;

/**
 * @author yanwenjie
 * @since 2018/12/12
 */
public class Solution21 {
    /**
     * 合并两个链表
     */
    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        if (l1 == null) {
            return null;
        }
        if (l2 == null) {
            return null;
        }
        ListNode21 res = new ListNode21(0);
        ListNode21 tail = res;
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
