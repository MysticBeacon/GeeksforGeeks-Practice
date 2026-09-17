import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {

        // Create adjacency list
        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // For every edge u -> v:
        // Going u -> v costs 0
        // Going v -> u means reversing the edge, so costs 1
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(v, 0));
            graph[v].add(new Edge(u, 1));
        }

        // Minimum number of reversals required
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // Deque for 0-1 BFS
        Deque<Integer> deque = new ArrayDeque<>();

        dist[src] = 0;
        deque.addFirst(src);

        while (!deque.isEmpty()) {

            int u = deque.pollFirst();

            for (Edge edge : graph[u]) {

                int v = edge.to;
                int cost = edge.cost;

                if (dist[u] + cost < dist[v]) {

                    dist[v] = dist[u] + cost;

                    // If cost is 0, process immediately
                    if (cost == 0) {
                        deque.addFirst(v);
                    }

                    // If cost is 1, process later
                    else {
                        deque.addLast(v);
                    }
                }
            }
        }

        // Destination cannot be reached
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}