package letcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CarryJey
 * @since 2018/12/15
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelGet(res, root, 0);
        for (int i = 0; i < res.size() / 2; i++) {
            List<Integer> temp = res.get(i);
            res.set(i, res.get(res.size() - i - 1));
            res.set(res.size() - i - 1, temp);
        }
        return res;
    }

    public void levelGet(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            res.add(list);
        } else {
            res.get(level).add(node.val);
        }
        levelGet(res, node.left, level + 1);
        levelGet(res, node.right, level + 1);
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(3);
        TreeNode root = node;
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node = node.right;
        node.left = new TreeNode(15);
        node.right = new TreeNode(7);
        levelOrderBottom(root);
    }
}
