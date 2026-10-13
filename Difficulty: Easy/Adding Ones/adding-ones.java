import java.util.*;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] arr = new int[n];

        // Count updates at each starting index
        for (int j : updates) {
            arr[j - 1]++;
        }

        // Calculate prefix sums
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        // Convert array to ArrayList
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            result.add(num);
        }

        return result;
    }
}