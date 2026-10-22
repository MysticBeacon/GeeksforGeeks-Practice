
class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int m = n / 2;

        char[] a = new char[m];

        // Each mirrored pair must contain the same character.
        for (int i = 0; i < m; i++) {
            char left = s.charAt(i);
            char right = s.charAt(n - 1 - i);

            if (left != '?' && right != '?' && left != right) {
                return -1;
            }

            if (left != '?') {
                a[i] = left;
            } else if (right != '?') {
                a[i] = right;
            } else {
                a[i] = '?';
            }
        }

        // A single character is already a palindrome.
        if (m == 0) {
            return 0;
        }

        final int INF = 1_000_000_000;
        int[] dp = new int[26];
        int[] next = new int[26];

        // Initialize the first mirrored pair.
        for (int c = 0; c < 26; c++) {
            dp[c] = (a[0] == '?' || a[0] == 'a' + c)
                    ? 0 : INF;
        }

        // Process each subsequent mirrored pair.
        for (int i = 1; i < m; i++) {
            int best = INF;

            // Left-to-right minimum distance transform.
            for (int c = 0; c < 26; c++) {
                best = Math.min(best, dp[c] - c);
                next[c] = best + c;
            }

            best = INF;

            // Right-to-left minimum distance transform.
            for (int c = 25; c >= 0; c--) {
                best = Math.min(best, dp[c] + c);
                next[c] = Math.min(next[c], best - c);
            }

            // Restrict this pair to its required character, if any.
            for (int c = 0; c < 26; c++) {
                if (a[i] != '?' && a[i] != 'a' + c) {
                    next[c] = INF;
                }
            }

            int[] temp = dp;
            dp = next;
            next = temp;
        }

        int best = INF;

        // Handle the middle character for odd-length strings.
        if (n % 2 == 1) {
            char center = s.charAt(m);

            for (int c = 0; c < 26; c++) {
                if (center == '?' || center == 'a' + c) {
                    best = Math.min(best, dp[c]);
                }
            }

            int[] temp = new int[26];

            for (int c = 0; c < 26; c++) {
                temp[c] = (center == '?' || center == 'a' + c)
                        ? Math.abs(c - (center == '?' ? c : center - 'a'))
                        : INF;
            }

            // Minimize the cost of connecting the last pair to the center.
            best = INF;
            for (int c = 0; c < 26; c++) {
                if (center != '?' && center != 'a' + c) {
                    continue;
                }
                for (int p = 0; p < 26; p++) {
                    best = Math.min(best, dp[p] + Math.abs(p - c));
                }
            }
        } else {
            for (int c = 0; c < 26; c++) {
                best = Math.min(best, dp[c]);
            }
        }

        return best * 2;
    }
}
