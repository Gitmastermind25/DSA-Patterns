package BinaryTree;

import java.util.*;

public class MaxDepthOfBT {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9  20
                 / \
                15  7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepthOfBT obj = new MaxDepthOfBT();

        int result = obj.maxDepth(root);

        System.out.println("Maximum Depth: " + result);
    }
}