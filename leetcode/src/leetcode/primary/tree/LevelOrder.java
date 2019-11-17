package leetcode.primary.tree;

import java.util.*;

/**
 * 二叉树的层次遍历
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        List<List<Integer>> result = new LevelOrder().levelOrder(treeNode);

        for (List<Integer> items : result) {
            System.out.println();
            for (Integer item : items) {
                System.out.print(item + " ");
            }
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            List<Integer> firstLevelNodeList = new ArrayList<>();
            result.add(firstLevelNodeList);
            Stack<TreeNode> tempStack = new Stack<TreeNode>();
            for (int i = 0, len = stack.size(); i < len; i++) {
                TreeNode node = stack.pop();
                firstLevelNodeList.add(node.val);
                if (node.left != null) {
                    tempStack.add(node.left);
                }
                if (node.right != null) {
                    tempStack.add(node.right);
                }
            }
            for (int i = 0, len = tempStack.size(); i < len; i++) {
                stack.add(tempStack.pop());
            }
        }
        return result;
    }
}
