import java.util.*;

class Solution {

    public int longIncPath(int[][] matrix, int n, int m) {

        int[][] indegree = new int[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Integer> queue = new ArrayDeque<>();

        // Calculate indegree
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        matrix[nr][nc] < matrix[r][c]) {

                        indegree[r][c]++;
                    }
                }

                // Starting points
                if (indegree[r][c] == 0) {
                    queue.offer(r * m + c);
                }
            }
        }

        int ans = 0;

        // Topological BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            // Each level represents one element of the path
            ans++;

            for (int i = 0; i < size; i++) {

                int curr = queue.poll();

                int r = curr / m;
                int c = curr % m;

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        matrix[nr][nc] > matrix[r][c]) {

                        indegree[nr][nc]--;

                        if (indegree[nr][nc] == 0) {
                            queue.offer(nr * m + nc);
                        }
                    }
                }
            }
        }

        return ans;
    }
}