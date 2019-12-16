package leetcode.primary.tree;

/**
 * 二叉搜索树中的搜索
 *
 */
public class SearchinaBinarySearchTree {

    public static void main(String[] args) {

    }

    /**
     * 第一种方案 使用递归
     * @param root
     * @param val
     * @return
     */
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


    /**
     * 使用 循环
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null) {
            if (root.val == val) {
                return root;
            }
            if(root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

}
