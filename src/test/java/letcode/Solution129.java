package letcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CarryJey
 * @since 2018/12/15
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        add(root, 0, list);
        int res = 0;
        for (int i : list) {
            //            res += i;
            System.out.print(i + "\n");
        }
        return res;
    }

    public void add(TreeNode node, int res, List<Integer> list) {
        if (node != null && node.left == null && node.right == null) {
            res = res * 10 + node.val;
            list.add(res);
            return;
        }

        res = res * 10 + node.val;
        add(node.left, res, list);
        add(node.right, res, list);
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode root = node;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = node.right;
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        sumNumbers(root);
    }
}
