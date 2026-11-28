
import java.util.*;

class Solution {
    boolean checkPath(ArrayList<ArrayList<Integer>> adj, int src, int dest) {

        int V = adj.size();

        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            if (node == dest) {
                return true;
            }

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}
