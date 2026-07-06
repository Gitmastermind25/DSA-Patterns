package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    // Definition of a Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to check whether a Binary Tree is Complete or not
    public boolean isCompleteTree(TreeNode root) {

        // Corner case: Empty tree is considered complete
        if (root == null) {
            return true;
        }

        // Queue for Level Order Traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS from the root
        queue.offer(root);

        // This flag becomes true after the first NULL node is encountered
        boolean past = false;

        // Traverse the tree level by level
        while (!queue.isEmpty()) {

            // Remove the front node from the queue
            TreeNode current = queue.poll();

            // If current node is NULL
            if (current == null) {

                // Mark that we have encountered a NULL node
                past = true;
            } else {

                // If a non-null node appears after a NULL node,
                // the tree is NOT a Complete Binary Tree.
                if (past) {
                    return false;
                }

                // Add left and right children to the queue
                // (Even if they are NULL)
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // If traversal completes without violation,
        // the tree is Complete.
        return true;
    }

    public static void main(String[] args) {

        CompleteBinaryTree obj = new CompleteBinaryTree();

        /*
                     1
                   /   \
                  2     3
                 / \   /
                4   5 6

            Complete Binary Tree
        */

        // Creating the tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        // Call the function
        boolean result = obj.isCompleteTree(root);

        // Print the result
        System.out.println("Is Complete Binary Tree? " + result);
    }
}