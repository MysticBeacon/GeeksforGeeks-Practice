import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {

        int n = mat.length;
        int m = mat[0].length;

        // 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Try every cell as a starting position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // First character must match
                if (mat[i][j] != word.charAt(0)) {
                    continue;
                }

                // Try all 8 directions
                for (int d = 0; d < 8; d++) {

                    int x = i;
                    int y = j;
                    int k;

                    // Check the word in this direction
                    for (k = 0; k < word.length(); k++) {

                        // Outside the grid
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            break;
                        }

                        // Character doesn't match
                        if (mat[x][y] != word.charAt(k)) {
                            break;
                        }

                        // Move to next cell
                        x += dx[d];
                        y += dy[d];
                    }

                    // Entire word matched
                    if (k == word.length()) {

                        ArrayList<Integer> position = new ArrayList<>();
                        position.add(i);
                        position.add(j);

                        ans.add(position);

                        // Avoid duplicate starting position
                        break;
                    }
                }
            }
        }

        return ans;
    }
}