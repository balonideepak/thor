package tree.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode root = binaryTreePaths.new TreeNode(1);
        root.left = binaryTreePaths.new TreeNode(2);
        root.right = binaryTreePaths.new TreeNode(3);
        root.left.right = binaryTreePaths.new TreeNode(5);

        List<String> result = binaryTreePaths.binaryTreePaths(root);
        System.out.println(result); // Output: ["1->2->5", "1->3"]
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        _binaryTreePaths(root, result, "");

        return result;
    }


    public void _binaryTreePaths(TreeNode node, List<String> result, String localResult) {

        if (node.left == null && node.right == null) {
            String temp1=localResult+"->"+node.val;
            result.add(temp1.replaceFirst("->",""));

        }

        if (node.left != null) {
            _binaryTreePaths(node.left, result, localResult + "->" + node.val);
        }

        if (node.right != null) {
            _binaryTreePaths(node.right, result, localResult + "->" +  node.val);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
