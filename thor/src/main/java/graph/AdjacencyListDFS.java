package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacencyListDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =new ArrayList();
        int v=4;
        for(int i=0; i<4 ;i++){
            adjList.add(new ArrayList());
        }

        addEdge(adjList , 0,1);
        addEdge(adjList , 0,2);
        addEdge(adjList , 1,2);
        addEdge(adjList , 2,3);

        //displayList(adjList);

        ArrayList<Integer> integers = dfsOfGraph(adjList);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList , int i , int j){
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    private static void displayList(ArrayList<ArrayList<Integer>> adjList){
        for(int i=0 ; i<adjList.size();i++){
            List<Integer> vertices = adjList.get(i);
            System.out.println("starting vertex : "+i);
            for(int vertex : vertices){
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }


    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] visited =new boolean[adj.size()];
        dfsOfGraphRec(adj , result , visited , 0);
        return result;
    }

    private static void dfsOfGraphRec(ArrayList<ArrayList<Integer>> adj ,
                               ArrayList<Integer> result ,
                               boolean[] visited ,int source ){

        visited[source] = true;
        result.add(source);

        for(int i : adj.get(source)){
            if(!visited[i]){
                dfsOfGraphRec(adj , result, visited , i);
            }
        }

    }

}
