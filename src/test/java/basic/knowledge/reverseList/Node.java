package basic.knowledge.reverseList;

/**
 * @Author: CarryJey @Date: 2018/10/15 11:48:26
 */

/**
 * 模拟链表实现
 * java不支持结构体，所以可以采用这种方式实现单链表
 */

public class Node {
    private int node;
    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
        super();
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
