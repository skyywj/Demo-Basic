package letcode;

/**
 * @author CarryJey
 * @since 2018/12/14
 */
public class Solution98 {
    double last = Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
