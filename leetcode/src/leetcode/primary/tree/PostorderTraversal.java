package leetcode.primary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class PostorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        List<Integer> result = new PostorderTraversal().postorderTraversal(treeNode);

        for (Integer item : result) {
            System.out.print(item + " ");
        }

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();

        iterator(result, root);

        return result;
    }

    private void iterator(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            iterator(result, root.left);
        }
        if (root.right != null) {
            iterator(result, root.right);
        }
        result.add(root.val);
    }
}
