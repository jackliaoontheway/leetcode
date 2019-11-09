package leetcode.primary.tree;

import java.util.*;

/**
 * 二叉树的后序遍历
 */
public class PostorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        List<Integer> result = new PostorderTraversal().postorderTraversal3(treeNode);

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


    /**
     * 第二种解决方案 使用循环
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (true) {
            if (root.left != null && !set.contains(root.left)) {
                root = root.left;
                stack.push(root);
                continue;
            }

            if (!set.contains(root)) {
                stack.push(root);
            }

            if (root.right != null && !set.contains(root.right)) {
                root = root.right;
                continue;
            }

            if (!set.contains(root)) {
                set.add(root);
                result.add(root.val);
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 第三种解决方案 使用Stack
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i).val);
        }
        return result;
    }
}
