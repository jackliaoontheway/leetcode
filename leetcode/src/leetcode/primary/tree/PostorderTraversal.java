package leetcode.primary.tree;

import java.util.*;

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
        while (true) {
            if (root.left != null) {
                root = root.left;
                continue;
            }

            stack.push(root);

            if (root.right != null) {
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
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
