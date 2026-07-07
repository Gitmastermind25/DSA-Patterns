package BinaryTree;
import java.util.*;

public class RightSideView {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Modified Preorder Traversal (Root -> Right -> Left)
    private void preOrder(TreeNode root, int level, List<Integer> result) {

        if (root == null) {
            return;
        }

        // First node visited at this level is the right-side view
        if (result.size() < level) {
            result.add(root.val);
        }

        preOrder(root.right, level + 1, result);
        preOrder(root.left, level + 1, result);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        preOrder(root, 1, result);

        return result;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
               \     \
                5     4

        Right Side View = [1, 3, 4]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideView obj = new RightSideView();

        List<Integer> result = obj.rightSideView(root);

        System.out.println("Right Side View: " + result);
    }
}
