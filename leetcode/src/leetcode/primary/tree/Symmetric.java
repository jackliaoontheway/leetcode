package leetcode.primary.tree;

import java.util.List;
import java.util.Stack;

/**
 * 对称二叉树
 */
public class Symmetric {


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        System.out.print(new Symmetric().isSymmetric(treeNode));
    }

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

        return inorderTraversal(root.left).equals(inorderTraversal2(root.right));
    }


    private String inorderTraversal(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            sb.append(root.val);
            root = root.right;
            if(root == null) {
                sb.append("x");
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    private String inorderTraversal2(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.right;
            }
            root = stack.pop();
            sb.append(root.val);
            root = root.left;
            if(root == null) {
                sb.append("x");
            }
        }
        System.out.println(sb);
        return sb.toString();
    }


}
