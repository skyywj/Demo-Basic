package test;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */
public class Node {

    public int value;
    public Node next;

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }
}
