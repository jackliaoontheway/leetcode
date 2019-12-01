package leetcode.primary.tree;

import java.util.Stack;

/**
 * 路径总和 第一种解决方案 使用递归
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        System.out.print(new PathSum().hasPathSum(treeNode, 5));

    }

    /**
     * 第一种解决方案 使用递归
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                if (current.left == null && current.right == null) {
                    if ((count + current.val) == sum) {
                        return true;
                    }
                } else {
                    if ((count + current.val) > sum) {
                        break;
                    }
                    count += current.val;
                }
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return false;
    }
}
