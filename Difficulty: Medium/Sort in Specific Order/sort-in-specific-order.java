
import java.util.*;

class Solution {
    void sortIt(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int[] result = new int[n];
        int index = 0;

        // First: Add odd numbers in descending order
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }

        // Second: Add even numbers in ascending order
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }

        // Copy result back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}
