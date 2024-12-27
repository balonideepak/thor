import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumInASlidingWindow {

    public static void main(String[] args) {
        int[] arr={12,1,78,90,57,89,56};
        int k=3;

        findMaxInSlidingWindow(arr,k);

    }

    private static void findMaxInSlidingWindow(int[] arr, int k){
        if(arr==null || arr.length==0){
            throw new IllegalArgumentException();
        }

        Deque<Integer> queue =new LinkedList();
        int i=0;
        for(;i<k;i++){

            while(!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }

        for( ; i<arr.length;i++){

            System.out.println(arr[queue.peek()]);

            while(!queue.isEmpty() && queue.peek() <= i-k){
                queue.removeFirst();
            }

            while(!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]){
                queue.removeLast();
            }

            queue.addLast(i);

        }

        System.out.println(arr[queue.peek()]);

    }
}
