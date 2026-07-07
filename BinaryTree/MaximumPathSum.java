package BinaryTree;

public class MaximumPathSum {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int maxSum;

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int neecheHiMilgayaAnswer = left + right + root.val;
        int koiEkAcha = Math.max(left, right) + root.val;
        int onlyRootAcha = root.val;

        maxSum = Math.max(maxSum,
                Math.max(neecheHiMilgayaAnswer,
                        Math.max(koiEkAcha, onlyRootAcha)));

        return Math.max(koiEkAcha, onlyRootAcha);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumPathSum obj = new MaximumPathSum();
        System.out.println("Maximum Path Sum = " + obj.maxPathSum(root));
    }
}