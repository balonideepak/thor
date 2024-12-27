import java.util.*;

public class KthSmallestElementInRowColumnWiseSortedArray {
    public static void main(String[] args) {
        int[][] mat = {
                        {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {24, 29, 37, 48},
                        {32, 33, 39, 50}
                      };

        approach1(mat);
        approach2(mat);

    }

    private static void approach1(int[][] mat) {
        List<Integer> list =new ArrayList<>();

        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                list.add(mat[i][j]);
            }
        }

        Collections.sort(list);
        Integer result = list.get(2);
        System.out.println(result);
    }

    private static void approach2(int[][] mat) {
        int n = mat.length;
        PriorityQueue<PQNode> pq =new PriorityQueue<>((a,b) -> a.data-b.data);

        for(int i=0;i<n;i++){
            //pq.offer(mat[0][i]);
        }
    }



    private static class PQNode {

        int data ;
        int r ;
        int c;

        public PQNode(int data, int r, int c) {
            this.data = data;
            this.r = r;
            this.c = c;
        }
    }
}
