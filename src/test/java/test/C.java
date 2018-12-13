package test;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */
public class C {

    Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node pre = null;
        Node pHead = null;
        while (cur != null) {
            Node next = cur.getNext();
            if(next == null){
                pHead = cur;
            }
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pHead;
    }
}
