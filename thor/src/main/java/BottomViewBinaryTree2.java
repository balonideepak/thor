import java.util.*;

public class BottomViewBinaryTree2 {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        ArrayList<Integer> integers = bottomView(root);
        System.out.println(integers);


    }

    public static ArrayList<Integer> bottomView(Node root)
    {
        // Code here

        if (root == null) return new ArrayList<>();

        // Map to store the last node at each
        // horizontal distance (HD)
        Map<Integer, Integer> hdMap = new TreeMap<>();

        // Queue to store nodes and their
        // horizontal distance
        Queue<Pair> q = new LinkedList<>();

        // Start level order traversal with
        // root at HD 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            // Get current node and its HD
            Node curr = q.peek().node;
            int hd = q.peek().hd;
            q.poll();

            // Update the map with the current
            // node's data
            hdMap.put(hd, curr.data);

            // Traverse the left subtree, HD - 1
            if (curr.left != null) {
                q.add(new Pair(curr.left, hd - 1));
            }

            // Traverse the right subtree, HD + 1
            if (curr.right != null) {
                q.add(new Pair(curr.right, hd + 1));
            }
        }

        // Extract bottom view nodes
        // from the map
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through the map in
        // sorted HD order
        for (int value : hdMap.values()) {
            result.add(value);
        }

        return result;

    }


    private static class Node{
        int data;
        Node left;
        Node right;

        int hd;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
}
