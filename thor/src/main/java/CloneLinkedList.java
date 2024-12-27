public class CloneLinkedList {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);


        root.random = root.next.next;
        root.next.random = root;
        root.next.next.random = root.next;
        root.next.next.next.next.random = root.next.next.next;

        Node curr = root;
        Node clonedNode = new Node(root.val);
        Node result=clonedNode;
        clonedNode.random=new Node(root.random.val);

        while (curr.next != null) {
            Node next = curr.next;
            Node random = curr.random;

            clonedNode.next = new Node(next.val);
            if (random != null)
                clonedNode.random = new Node(random.val);

            curr = curr.next;
            clonedNode = clonedNode.next;
        }

        System.out.println(result);
    }

    static class Node {
        Node next;
        Node random;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node() {
        }
    }
}
