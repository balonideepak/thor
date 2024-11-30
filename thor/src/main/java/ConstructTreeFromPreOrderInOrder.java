public class ConstructTreeFromPreOrderInOrder {
    public static void main(String[] args) {

        String[] in = {"D", "B" ,"E", "A", "F", "C" };
        String[] pre = {"A", "B", "D", "E", "C", "F"};

        int start = 0;
        int end = pre.length;
        Node node = constructTree(pre, in, start, end, new Index());
        System.out.println(node);
    }

    private static Node constructTree(String[] pre, String[] in, int start, int end, Index index) {
        if (start > end) {
            return null;
        }

        Node node = new Node(pre[index.index++]);
        int search = search(in, node, start, end);
        if (search == -1) {
            return null;
        }

        node.left = constructTree(pre, in, start, search - 1, index);
        node.right = constructTree(pre, in, search + 1, end, index);
        return node;

    }


    private static int search(String[] in, Node node, int start, int end) {
        for (int i = start; i < end; i++) {
            if (node.data.equalsIgnoreCase(in[i])) {
                return i;
            }
        }
        return -1;
    }
}

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

class Index {
    int index = 0;
}
