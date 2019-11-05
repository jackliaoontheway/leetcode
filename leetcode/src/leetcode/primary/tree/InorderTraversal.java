package leetcode.primary.tree;

import java.util.*;

/**
 * 中序遍历二叉树
 */
public class InorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        List<Integer> result = new InorderTraversal().inorderTraversal2(treeNode);

        for (Integer item : result) {
            System.out.print(item + " ");
        }

    }

    /**
     * 第一种解决方案 使用递归
     *
     * @param root
     * @return
     */
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

    /**
     * 第二种解决方案 使用循环
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        while (true) {
            if (root.left != null && !set.contains(root.left)) {
                stack.add(root);
                root = root.left;
                continue;
            }
            if (!set.contains(root)) {
                set.add(root);
                result.add(root.val);
            }
            if (root.right != null) {
                root = root.right;
                continue;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }
        }
        return result;
    }


}
