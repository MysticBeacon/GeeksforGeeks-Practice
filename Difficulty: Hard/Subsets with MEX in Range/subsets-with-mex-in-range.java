
class Solution {

    static final long MOD = 1000000007L;

    public int cntSubsets(int[] arr, int l, int r) {

        int n = arr.length;

        // Step 1: Frequency array
        int[] freq = new int[n + 1];

        for (int num : arr) {
            if (num >= 0 && num <= n) {
                freq[num]++;
            }
        }

        // Step 2: Precompute powers of 2
        long[] pow2 = new long[n + 1];

        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // Step 3: Calculate answer
        long lowerWays = 1;
        long ans = 0;

        int seen = 0;

        for (int k = 0; k <= r; k++) {

            // Count elements greater than k
            int greater = n - seen - freq[k];

            // Subsets having MEX exactly k
            long current = (lowerWays * pow2[greater]) % MOD;

            if (k >= l) {
                ans = (ans + current) % MOD;
            }

            // Update ways to select all numbers <= k
            long ways = (pow2[freq[k]] - 1 + MOD) % MOD;

            lowerWays = (lowerWays * ways) % MOD;

            seen += freq[k];
        }

        return (int) ans;
    }
}
