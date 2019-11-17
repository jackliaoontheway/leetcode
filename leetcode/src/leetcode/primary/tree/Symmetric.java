package leetcode.primary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 对称二叉树
 */
public class Symmetric {


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        System.out.print(new Symmetric().isSymmetric(treeNode));
    }

    /**
     * 方案一 使用List
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int len = queue.size();
            if (len % 2 != 0) {
                return false;
            }
            List<TreeNode> temp = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.get(i);
                TreeNode treeNode2 = queue.get(len - i - 1);
                if (treeNode != null) {
                    temp.add(treeNode.left);
                    temp.add(treeNode.right);
                }
                if (i < len / 2) {
                    if (treeNode != null && treeNode2 == null) {
                        return false;
                    }
                    if (treeNode == null && treeNode2 != null) {
                        return false;
                    }
                    if (treeNode != null && treeNode2 != null && treeNode.val != treeNode2.val) {
                        return false;
                    }
                }
            }
            queue = temp;
        }
        return true;
    }


}
