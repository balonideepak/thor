import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamOfNumbers {

    private static PriorityQueue<Integer> maxHeap ;
    private static PriorityQueue<Integer> minHeap ;

    public static void main(String[] args) {
        int[][] inputArr = {
                             {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                             {2, 3, 40, 20, 50}
                           };

        for (int[] arr : inputArr) {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();

            for (int i : arr) {
                addNum(i);
            }
            int median = findMedian();
            System.out.println(median);
        }
    }

    private static void addNum(int i) {
        maxHeap.offer(i);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private static int findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
