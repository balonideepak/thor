import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {

    //Time Complexity: O(n*log(n))
    //Auxiliary Space: O(n)

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        int result = minCost(arr);
        System.out.println(result);
    }

    private static int minCost(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue();

        for(int i : arr){
            pq.add(i);
        }

        int  first , second, result =0 ;
        while(pq.size()>1){
            first=pq.poll();
            second=pq.poll();
            result+= first + second;
            pq.add(first + second);
        }
        return result;
    }

}
