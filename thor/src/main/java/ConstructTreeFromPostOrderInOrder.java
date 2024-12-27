import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructTreeFromPostOrderInOrder {

    public static void main(String[] args) {

        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};

        Node root = buildTree(in, post);
        print(root);
    }
    static void print(Node curr) {
        if (curr == null)
            return;
        System.out.print(curr.data + " ");
        print(curr.left);
        print(curr.right);
    }

    static Node buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        // Create an unordered map to store the
        // indexes of inorder elements for quick lookup
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < len; i++)
            mp.put(inorder[i], i);

        // Initialize postorder index as the last element
        int[] postIndex = {len - 1};

        // Call the recursive utility function to build the tree
        return buildUtil(inorder, postorder, 0, len - 1, new Index(len-1), mp);
    }

    static Node buildUtil(int[] inorder, int[] postorder, int inStrt,
                          int inEnd, Index index, Map<Integer, Integer> mp) {

        // if start index exceeds end index, return null
        if (inStrt > inEnd)
            return null;

        // Get the current node value from postorder
        // traversal using pIndex and decrement pIndex
        int curr = postorder[index.index];
        Node node = new Node(curr);
        index.index--;

        // If the current node has no children
        // (inStrt == inEnd), return the node
        if (inStrt == inEnd)
            return node;

        // Find the index of the current node's
        // value in the inorder traversal
        int iIndex = mp.get(curr);

        // Recursively build the right and left subtrees
        node.right = buildUtil(inorder, postorder, iIndex + 1, inEnd, index, mp);
        node.left = buildUtil(inorder, postorder, inStrt, iIndex - 1, index, mp);

        return node;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    static class Index{
        int index;

        public Index(int index) {
            this.index = index;
        }
    }

}
