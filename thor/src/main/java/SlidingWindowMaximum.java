import java.util.*;

public class SlidingWindowMaximum {

    // Function to find the maximum element in each sliding
    // window of size k
    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> Qi = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        int N=arr.length;

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i) {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                    && arr[i] >= arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < N; ++i) {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            ans.add(arr[Qi.peek()]);

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        ans.add(arr[Qi.peek()]);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 84 ,34 ,35 ,45 ,30 ,91 ,50 ,90 ,84 ,81 ,49 ,71 ,54 ,80 ,70 ,67 ,21 ,34 ,50 ,29 ,25 ,54 ,33 ,91 ,9 ,74 ,50
                ,1 ,74 ,98 ,78 ,65 ,19 ,99 ,81 ,17 ,88 ,12 ,13 ,25 ,18 ,28 ,38 ,30 ,53 ,68 ,70 ,12 ,35 ,6 ,37 ,51 ,16 ,47 ,7 ,31 ,98 ,37 ,45 ,42 ,16 ,16};
        int k = 13;

        // Find the maximum element in each sliding window of
        // size k
        List<Integer> result = maxSlidingWindow(arr, k);

        // Print the results
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}