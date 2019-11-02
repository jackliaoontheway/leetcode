package leetcode.primary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历二叉树
 */
public class InorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        List<Integer> result = new InorderTraversal().inorderTraversal(treeNode);

        for (Integer item : result) {
            System.out.print(item + " ");
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
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
        result.add(root.val);
        if (root.right != null) {
            iterator(result, root.right);
        }
    }


}
