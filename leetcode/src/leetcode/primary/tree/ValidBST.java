package leetcode.primary.tree;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/submissions/detail/39134833/
 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
 */
public class ValidBST {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        System.out.print(new ValidBST().isValidBST2(treeNode));
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        Integer val = root.val;
        if (lower != null && lower > val) {
            return false;
        }
        if (upper != null && upper < val) {
            return false;
        }

        if (!isValidBST(root.right, val, upper)) {
            return false;
        }
        if (!isValidBST(root.left, lower, val)) {
            return false;
        }

        return true;
    }

    /**
     * 第二种解决方案 使用递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        Stack<Integer> mStack = new Stack<>();
        mStack.add(root.val);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            int prev = mStack.pop();
            if (current.right != null) {
                if (current.val >= current.right.val) {
                    return false;
                }
                if (current.val < prev) {
                    TreeNode temp = current.right;
                    while (temp != null) {
                        if (temp.val >= prev) {
                            return false;
                        }
                        temp = temp.right;
                    }
                }
                stack.add(current.right);
                mStack.add(current.val);
            }
            if (current.left != null) {
                if (current.val <= current.left.val) {
                    return false;
                }
                if (current.val > prev) {
                    TreeNode temp = current.left;
                    while (temp != null) {
                        if (temp.val <= prev) {
                            return false;
                        }
                        temp = temp.left;
                    }
                }
                stack.add(current.left);
                mStack.add(current.val);
            }
        }
        return true;
    }
}
