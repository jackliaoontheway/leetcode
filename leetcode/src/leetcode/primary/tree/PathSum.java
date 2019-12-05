package leetcode.primary.tree;

import java.util.Stack;

/**
 * 路径总和 第一种解决方案 使用递归
 * 第二种解决方案 使用循环 + stack
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        System.out.print(new PathSum().hasPathSum3(treeNode, 7));

    }

    /**
     * 第一种解决方案 使用递归
     *
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


    /**
     * 第二种解决方案 使用循环 + stack
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.add(current);
                sum -= current.val;
                if (current.right != null) {
                    sumStack.add(sum);
                }
                current = current.left;
            }
            current = stack.pop();
            if(current.left == null && current.right == null) {
                if(sum == 0) {
                    return true;
                }
            }
            current = current.right;
            if(current != null) {
                sum = sumStack.pop();
            }
        }
        return false;
    }

    /**
     * 第三种解决方案
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        Stack<Integer> sumStack = new Stack<>();
        sumStack.add(sum - root.val);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            sum = sumStack.pop();
            if(current.left == null && current.right == null) {
                if(sum == 0) {
                    return true;
                }
            }
            if(current.right != null) {
                sumStack.add(sum - current.right.val);
                stack.add(current.right);
            }
            if(current.left != null) {
                sumStack.add(sum - current.left.val);
                stack.add(current.left);
            }
        }
        return false;
    }
}
