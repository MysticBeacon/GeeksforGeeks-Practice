class Solution {
    public long maxProduct(int[] arr, int k) {
        int n = arr.length;

        // dp[j][p] = maximum product using j elements
        // We use two states:
        // maxDp[j] = maximum product
        // minDp[j] = minimum product
        //
        // We need both because multiplying a negative number
        // with the minimum product can produce the maximum product.

        long[] maxDp = new long[k + 1];
        long[] minDp = new long[k + 1];

        // Initialize
        for (int i = 0; i <= k; i++) {
            maxDp[i] = Long.MIN_VALUE;
            minDp[i] = Long.MAX_VALUE;
        }

        maxDp[0] = 1;
        minDp[0] = 1;

        for (int num : arr) {

            // Traverse backwards so that the current element
            // is not used more than once.
            for (int j = k; j >= 1; j--) {

                long newMax = Long.MIN_VALUE;
                long newMin = Long.MAX_VALUE;

                if (maxDp[j - 1] != Long.MIN_VALUE) {
                    long product = maxDp[j - 1] * num;
                    newMax = Math.max(newMax, product);
                    newMin = Math.min(newMin, product);
                }

                if (minDp[j - 1] != Long.MAX_VALUE) {
                    long product = minDp[j - 1] * num;
                    newMax = Math.max(newMax, product);
                    newMin = Math.min(newMin, product);
                }

                // Also keep the previous state (don't select num)
                newMax = Math.max(newMax, maxDp[j]);
                newMin = Math.min(newMin, minDp[j]);

                maxDp[j] = newMax;
                minDp[j] = newMin;
            }
        }

        return maxDp[k];
    }
}