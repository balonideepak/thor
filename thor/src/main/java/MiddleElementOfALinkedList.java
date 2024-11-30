public class MiddleElementOfALinkedList {

    public static void main(String[] args) {
        int[] arr = {20, 15, 2, 13, 2, 10, 13, 3, 2};
        Node node = new Node(20);
        node.next = new Node(15);
        node.next.next = new Node(2);
        node.next.next.next = new Node(13);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next = new Node(13);
        node.next.next.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next.next.next = new Node(6);
        int middle = getMiddle(node);
        System.out.println(middle);


    }

    static int getMiddle(Node head) {
        // Your code here.
        Node fastPointer = head.next;
        Node slowPointer = head;
        while (fastPointer != null && slowPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        if(fastPointer==null){
            return slowPointer.data;
        }
        else{
            return slowPointer.next.data;
        }

    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
