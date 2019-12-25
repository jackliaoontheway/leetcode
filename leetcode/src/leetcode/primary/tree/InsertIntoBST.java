package leetcode.primary.tree;

/**
 * Insert into a Binary Search Tree
 * 二叉搜索树中的插入操作
 */
public class InsertIntoBST {

    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        insertIntoBST(root, new TreeNode(val));

        return root;
    }

    public void insertIntoBST(TreeNode root, TreeNode target) {
        if (root.val > target.val) {
            if (root.left == null)
                root.left = target;
            else
                insertIntoBST(root.left, target);
        } else {
            if (root.right == null)
                root.right = target;
            else
                insertIntoBST(root.right, target);
        }
    }
}
