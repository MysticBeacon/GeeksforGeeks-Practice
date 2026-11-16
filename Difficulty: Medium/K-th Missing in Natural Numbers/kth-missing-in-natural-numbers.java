
import java.util.Arrays;

class Solution {
    public int findKthSmall(int[] arr, int k) {

        Arrays.sort(arr);

        int low = 1;
        int high = k + arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Find count of elements <= mid
            int left = 0;
            int right = arr.length;

            while (left < right) {
                int m = left + (right - left) / 2;

                if (arr[m] <= mid) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }

            int remaining = mid - left;

            if (remaining < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
