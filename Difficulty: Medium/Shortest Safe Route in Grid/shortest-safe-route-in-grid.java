import java.util.*;

class Solution {

    static class Cell {
        int row;
        int col;
        int dist;

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int shortestPath(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // unsafe[i][j] = true means we cannot enter this cell
        boolean[][] unsafe = new boolean[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // ---------------------------------------
        // STEP 1: Mark mines and their neighbours
        // ---------------------------------------
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {

                    // Mine itself is unsafe
                    unsafe[i][j] = true;

                    // Mark four neighbouring cells unsafe
                    for (int k = 0; k < 4; k++) {

                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < m) {

                            unsafe[nr][nc] = true;
                        }
                    }
                }
            }
        }

        // ---------------------------------------
        // STEP 2: BFS
        // ---------------------------------------
        Queue<Cell> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        // Start from every safe cell in first column
        // Distance starts at 1 because GFG counts cells
        for (int i = 0; i < n; i++) {

            if (!unsafe[i][0]) {

                queue.offer(new Cell(i, 0, 1));
                visited[i][0] = true;
            }
        }

        // ---------------------------------------
        // STEP 3: BFS traversal
        // ---------------------------------------
        while (!queue.isEmpty()) {

            Cell current = queue.poll();

            int r = current.row;
            int c = current.col;
            int dist = current.dist;

            // Reached last column
            if (c == m - 1) {
                return dist;
            }

            // Try all four directions
            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                // Check boundaries
                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m) {

                    // Cell must be safe and unvisited
                    if (!unsafe[nr][nc] && !visited[nr][nc]) {

                        visited[nr][nc] = true;

                        queue.offer(
                            new Cell(nr, nc, dist + 1)
                        );
                    }
                }
            }
        }

        // No safe path exists
        return -1;
    }
}