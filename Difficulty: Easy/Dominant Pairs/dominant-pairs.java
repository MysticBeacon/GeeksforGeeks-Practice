import java.util.*;

class Solution {
    public long dominantPairs(int[] arr) {
        int n = arr.length / 2;

        int[] first = new int[n];
        int[] second = new int[n];

        // Split the array into two halves
        for (int i = 0; i < n; i++) {
            first[i] = arr[i];
            second[i] = arr[n + i];
        }

        // Sort both halves
        Arrays.sort(first);
        Arrays.sort(second);

        long count = 0;
        int j = 0;

        // For every element in the first half,
        // find how many elements in the second half satisfy:
        // first[i] >= 5 * second[j]
        for (int i = 0; i < n; i++) {

            while (j < n && (long) first[i] >= 5L * second[j]) {
                j++;
            }

            count += j;
        }

        return count;
    }
}