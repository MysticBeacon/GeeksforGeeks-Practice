
class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];

        // Calculate suffix minimums
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        int prefixMax = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > prefixMax &&
                (i == n - 1 || arr[i] < suffixMin[i + 1])) {
                count++;
            }

            prefixMax = Math.max(prefixMax, arr[i]);
        }

        return count;
    }
}
