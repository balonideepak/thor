public class AddAllGreaterValuesToEveryNodeInABST {

    public static void main(String[] args) {
        // Representation of input binary tree:
        //           50
        //         /    \
        //        30    70
        //      /  \     / \
        //     20  40  60  80
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        Sum sum=new Sum();
        add(root,sum);

        printInOrder(root);
    }



    private static void add(Node node, Sum sum) {

        if(node== null){
            return;
        }

        add(node.right , sum);
        sum.sum= sum.sum + node.val;
        node.val=sum.sum;
        add(node.left , sum);

    }

    private static void printInOrder(Node node) {

        if(node == null){
            return;
        }

        printInOrder(node.left);
        System.out.println(node.val);
        printInOrder(node.right);
    }

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private static class Sum {
        int sum;
    }
}
