class Solution {

    public int minCount(int[] arr) {
        int n = arr.length;

        // dp[inc][dec] = maximum number of elements selected
        // inc = last index of increasing subsequence
        // dec = last index of decreasing subsequence
        //
        // n is used as a special value meaning "no element yet".
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        // Both subsequences are initially empty.
        dp[n][n] = 0;

        for (int k = 0; k < n; k++) {

            int[][] next = new int[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    next[i][j] = -1;
                }
            }

            for (int inc = 0; inc <= n; inc++) {
                for (int dec = 0; dec <= n; dec++) {

                    if (dp[inc][dec] == -1) {
                        continue;
                    }

                    int selected = dp[inc][dec];

                    // 1. Leave arr[k] unused
                    next[inc][dec] = Math.max(
                        next[inc][dec],
                        selected
                    );

                    // 2. Put arr[k] into increasing subsequence
                    if (inc == n || arr[k] > arr[inc]) {
                        next[k][dec] = Math.max(
                            next[k][dec],
                            selected + 1
                        );
                    }

                    // 3. Put arr[k] into decreasing subsequence
                    if (dec == n || arr[k] < arr[dec]) {
                        next[inc][k] = Math.max(
                            next[inc][k],
                            selected + 1
                        );
                    }
                }
            }

            dp = next;
        }

        // Find maximum number of elements selected.
        int maxSelected = 0;

        for (int inc = 0; inc <= n; inc++) {
            for (int dec = 0; dec <= n; dec++) {
                maxSelected = Math.max(maxSelected, dp[inc][dec]);
            }
        }

        // Elements that couldn't be selected.
        return n - maxSelected;
    }
}