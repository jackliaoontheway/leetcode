package leetcode.primary.tree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode getData() {

        TreeNode treeNode0 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        //TreeNode treeNode3 = new TreeNode(0);
        //TreeNode treeNode4 = new TreeNode(2);
        //TreeNode treeNode5 = new TreeNode(4);
        //TreeNode treeNode6 = new TreeNode(6);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        //treeNode1.left = treeNode3;
        //treeNode1.right = treeNode4;
        // treeNode2.left = treeNode5;
        // treeNode2.right = treeNode6;

        return treeNode0;
    }

}
