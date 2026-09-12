import java.util.*;

class Solution {

    static class Result {
        int node;
        int distance;

        Result(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static Result bfs(ArrayList<ArrayList<Integer>> adj, int start) {

        int n = adj.size();

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        dist[start] = 0;
        queue.offer(start);

        int farthestNode = start;
        int farthestDistance = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int value : adj.get(node)) {

                // Houses are numbered 1 to n,
                // but Java array/list indexes are 0 to n-1.
                int next = value - 1;

                if (dist[next] == -1) {

                    dist[next] = dist[node] + 1;

                    queue.offer(next);

                    if (dist[next] > farthestDistance) {
                        farthestDistance = dist[next];
                        farthestNode = next;
                    }
                }
            }
        }

        return new Result(farthestNode, farthestDistance);
    }

    static int partyHouse(ArrayList<ArrayList<Integer>> adj) {

        // First BFS:
        // Find one endpoint of the diameter.
        Result first = bfs(adj, 0);

        int diameterStart = first.node;

        // Second BFS:
        // Find the diameter length.
        Result second = bfs(adj, diameterStart);

        int diameter = second.distance;

        // Minimum possible maximum distance
        // = ceil(diameter / 2)
        return (diameter + 1) / 2;
    }
}