import java.util.*;

class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;

        // 0 = unvisited, 1 = visiting, 2 = good, 3 = bad
        int[] state = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (state[i] != 0) {
                continue;
            }

            ArrayList<Integer> path = new ArrayList<>();
            int curr = i;

            while (curr >= 0 && curr < n && state[curr] == 0) {
                state[curr] = 1;
                path.add(curr);
                curr += arr[curr];
            }

            int result;

            if (curr < 0 || curr >= n) {
                result = 2; // Good: exited the array
            } else if (state[curr] == 2) {
                result = 2; // Reaches a known good index
            } else {
                result = 3; // Reaches a cycle or a bad index
            }

            for (int index : path) {
                state[index] = result;
            }
        }

        for (int i = 0; i < n; i++) {
            if (state[i] == 2) {
                count++;
            }
        }

        return count;
    }
}