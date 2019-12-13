package leetcode.primary.tree;

/**
 * 二叉搜索树中的搜索
 */
public class SearchinaBinarySearchTree {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
