package leetcode.atlassian;

import java.util.PriorityQueue;
import java.util.*;

public class FindClosestElements {

    //https://leetcode.com/discuss/post/5857882/atlassian-senior-software-engineer-by-an-40or/
    //https://leetcode.com/problems/find-k-closest-elements/description/

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println(result); // Output: [1, 2, 3, 4]

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;

    }

}
