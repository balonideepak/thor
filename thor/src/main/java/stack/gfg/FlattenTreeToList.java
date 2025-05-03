package stack.gfg;

public class FlattenTreeToList {

    private TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(5);
        node.left.left=new TreeNode(3);
        node.left.right=new TreeNode(4);
        node.right.right=new TreeNode(6);

        FlattenTreeToList flattenTreeToList = new FlattenTreeToList();
        flattenTreeToList.flatten(node);

    }
    public void flatten(TreeNode root) {

        if (root == null) return;

        // Process right subtree first
        flatten(root.right);

        // Process left subtree
        flatten(root.left);

        // Set the current node's right to prev and left to null
        root.right = prev;
        root.left = null;

        // Update prev to current node
        prev = root;

    }

    static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
