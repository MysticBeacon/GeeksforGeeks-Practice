
class Solution {
    public int maxPackages(int[] arr, int totalTime) {

        int n = arr.length;

        // Window size cannot exceed array length
        int k = Math.min(totalTime, n);

        // Calculate sum of first window
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Apply sliding window
        for (int i = k; i < n; i++) {

            windowSum -= arr[i - k];
            windowSum += arr[i];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
