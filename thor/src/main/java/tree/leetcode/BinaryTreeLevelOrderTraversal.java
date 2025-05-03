package tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        MirrorTree.TreeNode root = new MirrorTree.TreeNode(1);
        root.left = new MirrorTree.TreeNode(2);
        root.right = new MirrorTree.TreeNode(3);
        root.left.left = new MirrorTree.TreeNode(4);
        root.left.right = new MirrorTree.TreeNode(5);

        root.right.left = new MirrorTree.TreeNode(6);
        root.right.right = new MirrorTree.TreeNode(7);

        ArrayList<ArrayList<Integer>> arrayLists = binaryTreeLevelOrderTraversal(root);
        System.out.println(arrayLists);

    }

    private static ArrayList<ArrayList<Integer>> binaryTreeLevelOrderTraversal(MirrorTree.TreeNode root) {
        Queue<MirrorTree.TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        queue.add(root);
        int currLevel = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            res.add(new ArrayList<>());


            for (int i = 0; i < size; i++) {
                MirrorTree.TreeNode poll = queue.poll();

                res.get(currLevel).add(poll.val);

                if(poll.left!=null){
                    queue.add(poll.left);
                }

                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }

            currLevel++;

        }

        return res;


    }


}
