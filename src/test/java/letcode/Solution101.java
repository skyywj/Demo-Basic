package letcode;

/**
 * @author CarryJey
 * @since 2018/12/14
 */

/**
 * 深度优先搜索之---判断一棵树是否是完全镜像树 遍历用栈存储，时间复杂度为O(n)
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return (root.val == root1.val) && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }
}
