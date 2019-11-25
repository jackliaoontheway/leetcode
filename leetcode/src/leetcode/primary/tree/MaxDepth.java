package leetcode.primary.tree;

/**
 * 二叉树的最大深度
 * 方案一 ： 使用递归
 */
public class MaxDepth {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        System.out.println(new MaxDepth().maxDepth(treeNode));
    }

    private int maxDepth = 0;

    /**
     * 使用递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDepth;
        }
        maxDepth(root, 1);
        return maxDepth;
    }

    public void maxDepth(TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        maxDepth = Math.max(maxDepth, depth);

        maxDepth(root.left, depth + 1);

        maxDepth(root.right, depth + 1);
    }

}
