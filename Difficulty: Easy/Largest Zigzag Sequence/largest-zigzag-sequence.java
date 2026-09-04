class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        // Process each remaining row
        for (int i = 1; i < n; i++) {

            // Find largest and second largest dp values
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    maxIndex = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {

                // Cannot choose the same column
                if (j == maxIndex) {
                    newDp[j] = mat[i][j] + max2;
                } else {
                    newDp[j] = mat[i][j] + max1;
                }
            }

            dp = newDp;
        }

        // Find maximum sum
        int ans = 0;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[j]);
        }

        return ans;
    }
}