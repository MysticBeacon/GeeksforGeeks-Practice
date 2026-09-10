class Solution {

    public int pairCount(int x, int y) {

        // LCM must be divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        // Check all divisors of n
        for (int p = 1; p * p <= n; p++) {

            if (n % p == 0) {

                int q = n / p;

                // p and q must be coprime
                if (gcd(p, q) == 1) {

                    if (p == q) {
                        // Only one pair when p == q
                        count++;
                    } else {
                        // (p,q) and (q,p) are distinct
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}