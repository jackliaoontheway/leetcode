package leetcode.primary.tree;

/**
 * Delete Node in a BST
 * 二叉搜索树中的删除操作
 */
public class DeleteNodeBST {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        deleteNode(null, root, val);
        return root;
    }

    public void deleteNode(TreeNode prev, TreeNode cur, int val) {

        if (cur.val == val) {
            if (cur.left == null && cur.right == null) {
                if(prev.val > cur.val) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            }



        }
    }


}
