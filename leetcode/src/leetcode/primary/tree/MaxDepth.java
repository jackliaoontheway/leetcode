package leetcode.primary.tree;

/**
 * 二叉树的最大深度
 */
public class MaxDepth {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        System.out.println(new MaxDepth().maxDepth(treeNode));
    }

    private int maxDepth(TreeNode treeNode) {
        maxDepth(treeNode, 1);
        return maxDepth;
    }

    int maxDepth;

    private void maxDepth(TreeNode treeNode, int depth) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.left == null && treeNode.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }

        maxDepth(treeNode.left, depth + 1);
        maxDepth(treeNode.right, depth + 1);

    }

}
