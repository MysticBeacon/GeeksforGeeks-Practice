class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {

        int n = s1.length();
        int m = s2.length();

        // dp[j] = LCS length
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int diagonal = 0;

            for (int j = 1; j <= m; j++) {
                int temp = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = diagonal + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                diagonal = temp;
            }
        }

        int lcsLength = dp[m];

        long totalCost = (long) n * costS1 + (long) m * costS2;

        long savedCost = (long) lcsLength * (costS1 + costS2);

        return (int) (totalCost - savedCost);
    }
}