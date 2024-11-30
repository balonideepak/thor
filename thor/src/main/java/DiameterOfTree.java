public class DiameterOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        diameter(root);
    }

    private static int diameter(Node node) {
        if (node == null) {
            return 0;
        }

        Result result = new Result();
        height(node, result);
        return result.diameter;

    }

    private static int height(Node node, Result result) {

        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left, result);
        int rightHeight = height(node.right, result);
        result.diameter = Math.max(result.diameter, 1 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }


    static class Result {
        int diameter = Integer.MIN_VALUE;
    }

    static class Node {
        int data;
        Node left;
        Node right;

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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
