package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        int v = 4;
        for (int i = 0; i < 4; i++) {
            adjList.add(new ArrayList());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);

        boolean cycle = isCycle(adjList);
        System.out.println("Is cycle detected : "+cycle);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }


    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == false)
                if (bfs(adj, i, vis)) {
                    return true;
                }
        }
        return false;
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int currentNode, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(currentNode, -1));
        vis[currentNode] = true;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int parent = current.parent;
            for (Integer i : adj.get(node)) {
                if (vis[i] == false) {
                    vis[i] = true;
                    q.add(new Pair(i, node));
                } else {
                    if (i != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
