
class Solution {
    public int largestSumCycle(int[] edge) {

        int n = edge.length;

        int[] state = new int[n];

        int maxSum = -1;

        for (int i = 0; i < n; i++) {

            if (state[i] != 0) {
                continue;
            }

            int[] path = new int[n];
            int len = 0;

            int curr = i;

            while (curr != -1 && state[curr] == 0) {

                state[curr] = 1;
                path[len++] = curr;

                curr = edge[curr];
            }

            if (curr != -1 && state[curr] == 1) {

                int sum = 0;
                int node = curr;

                do {
                    sum += node;
                    node = edge[node];

                } while (node != curr);

                maxSum = Math.max(maxSum, sum);
            }

            for (int j = 0; j < len; j++) {
                state[path[j]] = 2;
            }
        }

        return maxSum;
    }
}
