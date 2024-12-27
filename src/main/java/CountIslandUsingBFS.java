import java.util.LinkedList;
import java.util.Queue;

class CountIslandUsingBFS {


    //https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/#expected-approach-using-space-optimized-bfs-orows-cols-time-and-ominrows-cols-space
    public static void main(String[] args) {
        char[][] M = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '1', '0'}
        };

        Max max = new Max();
        System.out.println("island count=" + countIslands(M, max));
        System.out.println("max area=" + max.getArea());

        char[][] P = {{'1', '0', '0', '0', '1', '0', '0'},
                {'0', '1', '0', '0', '1', '1', '1'},
                {'1', '1', '0', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1', '0', '0'},
                {'1', '0', '0', '1', '0', '1', '1'}
        };

        max = new Max();
        System.out.println("island count=" + countIslands(P, max));
        System.out.println("max area=" + max.getArea());
    }

    // This function returns the number of islands
    // (connected components) in a graph
    static int countIslands(char[][] M, Max max) {

        // Mark all cells as not visited
        int rows = M.length;
        int cols = M[0].length;
        boolean[][] vis = new boolean[rows][cols];


        // Call BFS for every unvisited vertex
        // Whenever we see an unvisited vertex,
        // we increment res (number of islands)
        // also.
        int res = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (M[r][c] == '1' && !vis[r][c]) {
                    BFS(M, vis, r, c, max);
                    res++;
                }
            }
        }

        return res;
    }


    // Breadth-First-Search to visit all cells in the
    // current island
    static void BFS(char[][] M, boolean[][] vis,
                    int sr, int sc, Max max) {
        // These arrays are used to get row and
        // column numbers of 8 neighbours of
        // a given cell
        int[] rNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        int area = 1;

        // Simple BFS first step, we enqueue
        // source and mark it as visited
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;


        // Next step of BFS. We take out
        // items one by one from queue and
        // enqueue their unvisited adjacent
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];

            // Go through all 8 adjacent
            for (int k = 0; k < 8; k++) {
                int newR = r + rNbr[k];
                int newC = c + cNbr[k];
                if (isSafe(M, newR, newC, vis)) {
                    vis[newR][newC] = true;
                    area++;
                    q.add(new int[]{newR, newC});
                }
            }
        }

        int max1 = Math.max(max.getArea(), area);
        max.setArea(max1);
    }

    // A function to check if a given cell (r, c) 
    // can be included in BFS
    static boolean isSafe(char[][] M, int r, int c,
                          boolean[][] vis) {
        int rows = M.length;
        int cols = M[0].length;
        return (r >= 0) && (r < rows) && (c >= 0) &&
                (c < cols) && (M[r][c] == '1' && !vis[r][c]);
    }

    private static class Max {
        int area;

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }
    }

}