public class BoundaryLevelTraversal {
    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(8);
        node.right = new Node(22);
        node.left.left = new Node(4);
        node.left.right = new Node(12);
        node.left.right.left = new Node(10);
        node.left.right.right = new Node(14);
        node.right.right = new Node(25);

        printBoundary(node);
    }

    public static void printBoundary(Node node) {
        if (node != null) {
            System.out.println(node.val+" ");
        }
        printLeftBoundary(node.left);
        printLeaf(node.left);
        printLeaf(node.right);
        printRightBoundary(node.right);

    }

    public static void printLeftBoundary(Node node) {

        if (node != null) {
            if (node.left != null || node.right != null)
                System.out.println(node.val + "  ");
            if (node.left != null) {
                printLeftBoundary(node.left);
            } else {
                printLeftBoundary(node.right);
            }
        }
    }

    public static void printLeaf(Node node) {

        if (node != null) {
            printLeaf(node.left);
            if (node.left == null && node.right == null) {
                System.out.println(node.val + "  ");
            }
            printLeaf(node.right);
        }
    }


    public static void printRightBoundary(Node node) {

        if (node != null) {

            if (node.right != null) {
                printLeftBoundary(node.right);
            } else {
                printLeftBoundary(node.left);
            }
            if (node.left != null || node.right != null)
                System.out.println(node.val + "  ");
        }


    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
