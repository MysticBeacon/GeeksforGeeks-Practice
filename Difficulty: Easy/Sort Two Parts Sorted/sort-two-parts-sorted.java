class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int pivot = -1;

        // Find the break point
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                pivot = i;
                break;
            }
        }

        // Already sorted
        if (pivot == -1) {
            return;
        }

        int[] result = new int[n];
        int i = 0;
        int j = pivot;
        int k = 0;

        // Merge the two sorted parts
        while (i < pivot && j < n) {
            if (arr[i] <= arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }

        // Copy remaining elements
        while (i < pivot) {
            result[k++] = arr[i++];
        }

        while (j < n) {
            result[k++] = arr[j++];
        }

        // Copy result back into the original array
        System.arraycopy(result, 0, arr, 0, n);
    }
}