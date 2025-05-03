package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BFS {
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

        ArrayList<Integer> integers = bfsOfGraph(4, adjList);
        System.out.println(integers);

    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList , int i , int j){
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue =new LinkedList();
        ArrayList<Integer> result =new ArrayList();

        visited[0]=true;
        queue.add(0);

        while(queue.size()!=0){
            Integer elem = queue.poll();
            result.add(elem);

            List<Integer> vertices = adj.get(elem);
            for(int vertex : vertices){

                if(!visited[vertex]){
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }

        }

        return result;
    }

}
