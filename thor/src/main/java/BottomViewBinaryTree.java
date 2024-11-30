import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewBinaryTree {

    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println(bottomView(root));
    }

    public static ArrayList<Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> list=new ArrayList();
        TreeMap<Integer, Node> map=new TreeMap();
        inOrderTraversal(root,0 , map);

        for(Map.Entry<Integer, Node> entry : map.entrySet()){

            Node node=entry.getValue();
            if(null != node){
                list.add(node.data);
            }
        }

        return list;

    }

    private static void inOrderTraversal(Node node, int distance, TreeMap map){

        if(node == null){
            return ;
        }

        map.put(distance, node);

        inOrderTraversal(node.left,distance-1,map);
        inOrderTraversal(node.right, distance+1,map);
    }

    private static class Node{
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
    }


}

