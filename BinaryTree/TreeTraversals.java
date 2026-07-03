package BinaryTree;

public class TreeTraversals {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void preOrder(TreeNode root){
        if( root == null ){
            return;
        }
        System.out.println(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){
        if( root == null ){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val+ " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if( root == null ){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val+ " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Preorder:");
        preOrder(root);

        System.out.println();

        System.out.print("Postorder:");
        preOrder(root);

        System.out.println();

        System.out.print("Inorder:");
        inOrder(root);
    }
}
