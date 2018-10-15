package basic.knowledge.reverseList;

/**
 * @Author: CarryJey @Date: 2018/10/15 11:47:49
 */
public class MainRun {
    /**
     * 链表反转
     */
    public static Node reverseList(Node head) {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }
        //previous上一个节点
        Node preNode = null;
        //current节点当前节点，并让它指向传进来的对象所在地址（是保存该对象的地址，不是它的next值）
        Node curNode = head;
        //next节点下一个节点
        Node nextNode = null;

        while (curNode != null) {
            //让next节点指向后一个节点所在地址，并改变新地址的值（包括data，next）
            nextNode = curNode.getNext();

            //将current节点存储的地址（也就是next）的值改为preNode节点所指向的地址（这样就把指向箭头反转了）这儿有个误区
            //注意：是将preNode指向的地址给curNode的next，不是把preNode的next给它。
            curNode.setNext(preNode);

            //让previous节点指向的地址向后移动一个单位，并改变新地址的值（包括data，next）
            preNode = curNode;

            //让current节点的索引向后移动一个单位，并改变新地址的值包括（data，next）
            curNode = nextNode;
        }

        return preNode;
    }

    /**
     * 打印链表
     */
    public static void print(Node node){
        while (node != null) {
            System.out.print("data :" + node.getData());
            node = node.getNext();
            if (node != null) {
                System.out.println(" next :" + node.getData() + "\n");
            } else {
                System.out.println(" next :null" + "\n");
            }
        }
    }

    public static void main(String[] arg0) {

        //创建链表的节点，创建了三个对象，那就是三个节点
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        //将这些节点，串连起来形成链表
        node0.setNext(node1);
        node1.setNext(node2);

        //链表的头结点代表了该链表，因为头结点能找到第二个，第二个能找到第三个，依次找下去，全都找到了
        Node head1 = node0;
        System.out.print("---+++反转前的链表顺序+++-----\n");
        //先打印反转之前的链表的值
        print(head1);
        System.out.print("---+++反转后的链表顺序+++-----\n");

        //注意了，我们是从头开始反转，所以这儿不能用head1，因为head1在上面的while循环中已经成为最后一个节点了
        Node oldHead = node0;
        Node newHead = reverseList(oldHead);

        //打印反转后的节点
       print(newHead);
    }
}
