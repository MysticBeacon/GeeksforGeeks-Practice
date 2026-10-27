
class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Leave the current character unpaired
            dp[i] = dp[i - 1] + 1;

            // Pair the current character with the previous one
            if (i >= 2) {
                int pairWeight =
                    (s.charAt(i - 1) != s.charAt(i - 2)) ? 4 : 3;

                dp[i] = Math.max(dp[i], dp[i - 2] + pairWeight);
            }
        }

        return dp[n];
    }
}
