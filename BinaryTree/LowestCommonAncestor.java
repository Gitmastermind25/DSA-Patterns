package BinaryTree;

public class LowestCommonAncestor {

    // TreeNode class inside the same class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null) {
            return null;
        }

        // If current node is p or q
        if (root == p || root == q) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides found a node, current root is LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return whichever side found a node
        return left != null ? left : right;

        /*same meaning
        if (left != null) {
            return left;
        } else {
            return right;
        }*/
    }

    public static void main(String[] args) {

        LowestCommonAncestor obj = new LowestCommonAncestor();

        /*
                    3
                  /   \
                 5     1
                / \   / \
               6   2 0   8
                  / \
                 7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;              // Node 5
        TreeNode q = root.left.right.right;  // Node 4

        TreeNode ans = obj.lowestCommonAncestor(root, p, q);

        System.out.println("LCA = " + ans.val);
    }
}