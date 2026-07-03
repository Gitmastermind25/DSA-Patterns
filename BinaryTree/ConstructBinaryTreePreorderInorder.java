package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorder {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // HashMap to store each value's index in inorder traversal
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    // Pointer to the current root in preorder traversal
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        // STEP 1: Store value -> index mapping of inorder array
        // This allows O(1) lookup of a node's position.

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Build the entire tree
        return solve(preorder, 0, inorder.length - 1);
    }

    private TreeNode solve(int[] preorder, int start, int end) {


        // BASE CASE
        // No elements left in this inorder range.

        if (start > end) {
            return null;
        }


        // STEP 2: Current preorder element is the root.
        // Move preIndex to the next element.

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);


        // STEP 3: Find root's position in inorder.
        // Left side -> Left subtree
        // Right side -> Right subtree

        int inorderIndex = inorderMap.get(rootVal);


        // STEP 4: Build left subtree first because preorder is
        // Root -> Left -> Right

        root.left = solve(preorder, start, inorderIndex - 1);


        // STEP 5: Build right subtree.

        root.right = solve(preorder, inorderIndex + 1, end);


        // Return the constructed subtree.

        return root;
    }

    public static void main(String[] args) {

        ConstructBinaryTreePreorderInorder solution =
                new ConstructBinaryTreePreorderInorder();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("Root Node : " + root.val);
        System.out.println("Left Child: " + root.left.val);
        System.out.println("Right Child: " + root.right.val);
    }
}
