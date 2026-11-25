
class Solution {

    static final long MOD = 1_000_000_007L;

    public int minTime(int a, int b, int d, int l, int r) {

        long c = a - b;

        // Minimum time without using the special jump
        long k = (d - a + c - 1) / c;
        long normalTime = d + 2L * b * k;

        // Required q range: q = d - j
        long L = d - r;
        long R = d - l;

        long ans = 0;

        // Case 1: q <= a
        long low = L;
        long high = Math.min(R, (long) a);

        for (long q = low; q <= high; q++) {
            long jumpTime = q + 1;
            ans = (ans + Math.min(normalTime, jumpTime)) % MOD;
        }

        // Case 2: q > a
        low = Math.max(L, (long) a + 1);

        if (low <= R) {

            long step = a + b;

            // Process each remainder modulo c
            for (long rem = 0; rem < c; rem++) {

                // First number >= low with this remainder
                long first = low + (rem - low % c + c) % c;

                if (first > R) {
                    continue;
                }

                // Number of elements in this progression
                long count = (R - first) / c + 1;

                // Number of backward cycles
                long cycles = (first - a + c - 1) / c;

                // Time required for the first element
                long firstTime = 1 + first + 2L * b * cycles;

                // Count elements whose jump time is less than normalTime
                long useful = 0;

                if (firstTime < normalTime) {
                    useful = Math.min(
                        count,
                        (normalTime - 1 - firstTime) / step + 1
                    );
                }

                // Sum of the useful arithmetic progression
                long sum = useful * firstTime
                         + step * useful * (useful - 1) / 2;

                // Remaining elements use normal movement
                sum += (count - useful) * normalTime;

                ans = (ans + sum % MOD) % MOD;
            }
        }

        return (int) ans;
    }
}
