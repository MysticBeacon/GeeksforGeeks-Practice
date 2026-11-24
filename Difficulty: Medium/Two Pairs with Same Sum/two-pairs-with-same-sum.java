
import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {

        int n = arr.length;

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        // Generate all pairs and group them by sum
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int sum = arr[i] + arr[j];

                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }

        int[] best = null;

        // Check pairs having the same sum
        for (ArrayList<int[]> pairs : map.values()) {

            for (int i = 0; i < pairs.size(); i++) {

                int[] p1 = pairs.get(i);

                for (int j = i + 1; j < pairs.size(); j++) {

                    int[] p2 = pairs.get(j);

                    // All four indices must be distinct
                    if (p1[0] != p2[0] &&
                        p1[0] != p2[1] &&
                        p1[1] != p2[0] &&
                        p1[1] != p2[1]) {

                        int[] curr = {
                            p1[0], p1[1],
                            p2[0], p2[1]
                        };

                        // Compare lexicographically
                        if (best == null || isSmaller(curr, best)) {
                            best = curr;
                        }

                        // First valid second pair is smallest
                        break;
                    }
                }

                // First valid first pair for this sum is smallest
                if (best != null &&
                    best[0] == p1[0] &&
                    best[1] == p1[1]) {
                    break;
                }
            }
        }

        if (best == null) {
            return new ArrayList<>(
                Arrays.asList(-1, -1, -1, -1)
            );
        }

        return new ArrayList<>(
            Arrays.asList(best[0], best[1], best[2], best[3])
        );
    }

    // Checks lexicographical order
    private boolean isSmaller(int[] a, int[] b) {

        for (int i = 0; i < 4; i++) {
            if (a[i] < b[i]) return true;
            if (a[i] > b[i]) return false;
        }

        return false;
    }
}
