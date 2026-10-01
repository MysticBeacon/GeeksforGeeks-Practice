import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        // Adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph: u -> v
        int[] indegree = new int[n];

        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        // Earliest completion time of each module
        long[] finish = new long[n];

        for (int i = 0; i < n; i++) {
            finish[i] = duration[i];
        }

        // Modules having no dependencies
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processed = 0;
        long answer = 0;

        // Topological sort
        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;

            answer = Math.max(answer, finish[u]);

            for (int v : graph.get(u)) {

                // v can start only after u is completed
                finish[v] = Math.max(
                    finish[v],
                    finish[u] + duration[v]
                );

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // Cycle exists
        if (processed != n) {
            return -1;
        }

        return (int) answer;
    }
}