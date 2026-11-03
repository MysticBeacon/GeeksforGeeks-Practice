
import java.util.*;

class Solution {

    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    long union(int u, int v) {

        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return 0;
        }

        long a = size[rootU];
        long b = size[rootV];

        if (size[rootU] < size[rootV]) {
            int temp = rootU;
            rootU = rootV;
            rootV = temp;
        }

        parent[rootV] = rootU;
        size[rootU] += size[rootV];

        return a * b;
    }

    ArrayList<Integer> maximumWeight(
        int n, int[][] edges, int[] queries) {

        Arrays.sort(edges,
            (a, b) -> Integer.compare(a[2], b[2]));

        int m = queries.length;

        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        long[] result = new long[m];

        long count = 0;
        int edgeIndex = 0;

        for (int i = 0; i < m; i++) {

            int x = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            while (edgeIndex < edges.length &&
                   edges[edgeIndex][2] <= x) {

                int u = edges[edgeIndex][0];
                int v = edges[edgeIndex][1];

                count += union(u, v);

                edgeIndex++;
            }

            result[originalIndex] = count;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (long value : result) {
            ans.add((int) value);
        }

        return ans;
    }
}
