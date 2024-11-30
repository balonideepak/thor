import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeftOrderTreeTraversal {
    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);

        printLeftView(root);
    }

    private static void printLeftView(Node node) {
        if(node== null){
            return ;
        }

        Queue<Node> queue =new LinkedList();
        queue.add(node);
        Node lNode ;

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i< size; i++){
                lNode = queue.poll();

                if(i==0){
                    System.out.println(lNode.data);
                }

                if(lNode.left!=null){
                    queue.add(lNode.left);
                }

                if(lNode.right!=null){
                    queue.add(lNode.right);
                }

            }


        }

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
