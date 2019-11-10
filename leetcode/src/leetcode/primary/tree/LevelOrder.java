package leetcode.primary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的层次遍历
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        List<List<Integer>> result = new LevelOrder().levelOrder(treeNode);

        for (List<Integer> items : result) {
            for (Integer item : items) {
                System.out.print(item + " ");
            }
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        List<Integer> firstLevelNodeList = new ArrayList<>();
        firstLevelNodeList.add(root.val);
        result.add(firstLevelNodeList);

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            List<Integer> levelNodeList = new ArrayList<>();
            if (node.left != null) {
                stack.push(node.left);
                levelNodeList.add(node.left.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                levelNodeList.add(node.right.val);
            }
            if(levelNodeList.size() != 0) {
                result.add(levelNodeList);
            }
        }

        return result;
    }
}
