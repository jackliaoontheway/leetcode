package leetcode.primary.tree;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getData();

        BSTIterator iterator = new BSTIterator(treeNode);
        while(iterator.hasNext()) {
            System.out.print(iterator.next());
        }

    }

    Stack<Integer> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();
        while (root != null || !tempStack.isEmpty()) {
            while (root != null) {
                tempStack.push(root);
                root = root.right;
            }
            root = tempStack.pop();
            this.stack.push(root.val);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return stack.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


}
