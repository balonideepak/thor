package tree.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers sumOfRootToLeafBinaryNumbers = new SumOfRootToLeafBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int result = sumOfRootToLeafBinaryNumbers.sumRootToLeaf(root);
        System.out.println(result); // Output: 22

        int approach2Result = sumRootToLeaf(root, 0);
        System.out.println(approach2Result);
    }


    public static int sumRootToLeaf(TreeNode root, int sum){
        if(root == null) return 0;
        sum = (2 * sum) + root.val;
        if(root.left == null && root.right == null) return sum;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }


    public int sumRootToLeaf(TreeNode root) {

        List<String> result = new LinkedList<>();
        _sumRootToLeaf(root , result , "");
        int sum =0;

        for(String val : result){
            if("".equals(val)){
                sum = sum+0;
            }else{
                sum = sum+Integer.parseInt(val, 2);
            }

        }

        return sum;

    }

    private void _sumRootToLeaf(TreeNode node , List<String> result  , String localResult){

        if(node.left==null && node.right==null){
            localResult=localResult+node.val;
            result.add(localResult);
            return;
        }

        if (node.left != null) {
            _sumRootToLeaf(node.left , result , localResult+node.val);
        }
        if (node.right != null) {
            _sumRootToLeaf(node.right , result , localResult+node.val);
        }

    }

    private static class TreeNode {
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
