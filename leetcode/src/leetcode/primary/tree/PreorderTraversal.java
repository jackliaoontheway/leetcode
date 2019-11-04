package leetcode.primary.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PreorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getData();

        List<Integer> result = new PreorderTraversal().preorderTraversal2(treeNode);
        //List<Integer> result = new PreorderTraversal().preorderTraversal(treeNode);

        for (Integer item : result) {
            System.out.print(item + " ");
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();

        iterator(result, root);

        return result;
    }

    private void iterator(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            iterator(result, root.left);
        }
        if (root.right != null) {
            iterator(result, root.right);
        }
    }


    /**
     * 第二种解决方案不用递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        List<TreeNode> temp = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        while (true) {
            if (!set.contains(root)) {
                result.add(root.val);
                set.add(root);
            }
            if (root.left != null && !set.contains(root.left)) {
                temp.add(root);
                root = root.left;
                continue;
            }
            if (root.right != null) {
                root = root.right;
                continue;
            }
            if (!temp.isEmpty()) {
                root = temp.get(temp.size() - 1);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
        return result;
    }


}
