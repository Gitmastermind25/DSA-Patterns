package BinaryTree;

import java.util.*;

public class DeleteNodesAndReturnForest {

    // Definition of TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Postorder DFS function
    private TreeNode deleteHelper(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {

        // Base case
        if (root == null) {
            return null;
        }

        // Process left subtree first
        root.left = deleteHelper(root.left, toDelete, result);

        // Process right subtree
        root.right = deleteHelper(root.right, toDelete, result);

        // If current node needs to be deleted
        if (toDelete.contains(root.val)) {

            // Its children become new roots (if they exist)
            if (root.left != null) {
                result.add(root.left);
            }

            if (root.right != null) {
                result.add(root.right);
            }

            // Delete current node
            return null;
        }

        // Keep current node
        return root;
    }

    // Function to delete nodes and return the forest
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();

        // Store nodes to delete for O(1) lookup
        for (int value : to_delete) {
            toDelete.add(value);
        }

        // Delete the required nodes
        root = deleteHelper(root, toDelete, result);

        // If original root wasn't deleted,
        // it is also a root of one tree in the forest
        if (root != null) {
            result.add(root);
        }

        return result;
    }

    // Inorder Traversal to display a tree
    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        DeleteNodesAndReturnForest obj = new DeleteNodesAndReturnForest();

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7

            Delete Nodes = {3, 5}
        */

        // Creating the tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Nodes to delete
        int[] toDelete = {3, 5};

        // Get the forest after deletion
        List<TreeNode> forest = obj.delNodes(root, toDelete);

        // Print all trees in the forest
        System.out.println("Trees in the Forest:");

        int treeNumber = 1;

        for (TreeNode tree : forest) {
            System.out.print("Tree " + treeNumber + ": ");
            obj.inorder(tree);
            System.out.println();
            treeNumber++;
        }
    }
}