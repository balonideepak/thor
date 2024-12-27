public class LargestBSTInABinaryTree {


    public static void main(String[] args) {

        Node root=new Node(25);
        root.left=new Node(18);
        root.right=new Node(50);
        root.left.left=new Node(19);
        root.right.left=new Node(35);
        root.right.left.left=new Node(30);
        root.right.left.right=new Node(40);
        root.right.right=new Node(60);
        root.right.right.left=new Node(59);
        root.right.right.right=new Node(61);


        int result = largestBSTSize(root);
        System.out.println(result);

    }
    
    private static int largestBSTSize(Node node){
        if(node == null){
            throw new IllegalArgumentException();
        }
        
        return largestBSTSizeUtil(node);
    }

    private static int largestBSTSizeUtil(Node node) {
        MinMax m= largest(node);
        return m.size;
    }

    private static MinMax largest(Node node) {
        if(node == null){
            return new MinMax();
        }
        
        MinMax m =new MinMax();
        MinMax left=largest(node.left);
        MinMax right=largest(node.right);
        
        if(!left.isBST() || !right.isBST() || left.getMax() > node.val || right.getMin() < node.val){
            m.setIsBST(false);
            m.setSize(Math.max(left.getSize(), right.getSize()));
            return m;
        }
        
        m.setIsBST(true);
        m.setSize(left.getSize()+ right.getSize()+1);
        
        int leftVal , rightVal =0 ;
        
        if(node.left!=null){
            leftVal= left.getMin();
        }else{
            leftVal= node.val;
        }
        
        if(node.right!=null){
            rightVal = right.getMax();
        }else{
            rightVal = node.val;
        }
        
        m.setMin(leftVal);
        m.setMax(rightVal);
        
        return m;
        
        
    }
    


    static class MinMax {
        boolean isBST = true;
        int size = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        public void setIsBST(boolean isBST) {
            this.isBST = isBST;
        }

        public boolean isBST() {
            return isBST;
        }

        public int getSize() {
            return size;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    static class Node {
        Node left;
        Node right;
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
    }
}
