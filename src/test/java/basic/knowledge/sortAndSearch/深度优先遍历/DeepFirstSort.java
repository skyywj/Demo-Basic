package basic.knowledge.sortAndSearch.深度优先遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author CarryJey
 * @since 2018/10/30 desc : 深度优先遍历
 */
public class DeepFirstSort {

    public static List<Node> initTree(List<Integer> list) {
        List<Node> tree = new ArrayList<>();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            Node node = new Node();
            node.setNode(list.get(i));
            if (2 * i + 1 < list.size()) {
                int left = list.get(2 * i + 1);
                Node leftNode = new Node();
                leftNode.setNode(left);
                node.setLeft(leftNode);
            }
            if (2 * i + 2 < list.size()) {
                int right = list.get(2 * i + 2);
                Node rightNode = new Node();
                rightNode.setNode(right);
                node.setRight(rightNode);
            }
            tree.add(node);
        }
        return tree;
    }

    public static void searchTarget(List<Integer> list, Integer target) {
        List<Node> tree = initTree(list);
        Stack<Node> visited = new Stack<>();
        visited.push(tree.get(0));
        while (!visited.empty()){
            Node current = visited.pop();
            if(current.getRight()!=null){
                visited.push(current.getRight());
            }
            if(current.getLeft()!=null){
                visited.push(current.getLeft());
            }
            System.out.print(current.getNode());
        }
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(9);
        searchTarget(list,0);
//        List<Node> tree = initTree(list);
//        for(int i =0;i<tree.size();i++){
//            System.out.print(tree.get(i).getNode());
//        }
    }
}
